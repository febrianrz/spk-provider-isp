package alterindonesia.project.com.spkproviderisp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PaketListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerLayoutManager;

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
        recyclerAdapter = new RecylerAdapter(PaketListActivity.this, getData());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<Model> getData(){
        List<Model> arrData = new ArrayList<>();

        Model model = new Model();
        model.setProvider("Biznet");
        model.setHarga("Rp300.000");
        model.setPaket("Biznet Home");
        arrData.add(model);

        model = new Model();
        model.setProvider("MyRepublik");
        model.setHarga("Rp500.000");
        model.setPaket("MyRepublik GamerX1");
        arrData.add(model);

        model = new Model();
        model.setProvider("IndiHome");
        model.setHarga("Rp700.000");
        model.setPaket("IndieHome Family");
        arrData.add(model);

        return arrData;
    }
}
