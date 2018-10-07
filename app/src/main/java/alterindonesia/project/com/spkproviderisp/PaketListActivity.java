package alterindonesia.project.com.spkproviderisp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaketListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerLayoutManager;
    List<PaketResponse> arrData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List Paket Tersedia");
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerView.setVisibility(View.VISIBLE);
        recyclerAdapter = new RecylerAdapter(PaketListActivity.this, arrData);
        recyclerView.setAdapter(recyclerAdapter);
        String type = getIntent().getStringExtra("type");
        if(type.equals("list_all")){
            getDataFilter(null,null);
        } else {
            getDataFilter(getIntent().getIntExtra("budget",1), getIntent().getStringExtra("domisili"));
        }

    }

    private void getDataFilter(Integer budget, String domilisi){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Call<List<PaketResponse>> registerCall = service.getPaket(String.valueOf(budget),domilisi);

        registerCall.enqueue(new Callback<List<PaketResponse>>() {
            @Override
            public void onResponse(Call<List<PaketResponse>> call, Response<List<PaketResponse>> response) {
                try {
                    if(response.body().size() == 0){
                        recyclerView.setVisibility(View.GONE);
                        findViewById(R.id.llKosong).setVisibility(View.VISIBLE);
                        findViewById(R.id.btnList).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent =new Intent(PaketListActivity.this, PaketListActivity.class);
                                intent.putExtra("type","list_all");
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        arrData.addAll(response.body());
                        recyclerAdapter.notifyDataSetChanged();
                    }

                } catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<PaketResponse>> call, Throwable t) {
                Toast.makeText(PaketListActivity.this,"Error Mengambil Data",Toast.LENGTH_LONG);
            }
        });
    }

}
