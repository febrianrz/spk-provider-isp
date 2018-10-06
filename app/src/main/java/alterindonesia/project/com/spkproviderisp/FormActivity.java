package alterindonesia.project.com.spkproviderisp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    EditText etNama, etBudget;

    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Perhitungan");

        etNama      = (EditText) findViewById(R.id.etName);
        etBudget    = (EditText) findViewById(R.id.etPrice);
        btnSubmit   = (Button) findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){


                } else {
                    Toast.makeText(FormActivity.this,"Periksa kembali inputan Anda",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validation(){
        boolean isValid = true;
        if(TextUtils.isEmpty(etNama.getText().toString())){
            isValid = false;
            etNama.setError("Wajib diisi");
        }
        if(TextUtils.isEmpty(etBudget.getText().toString())){
            isValid = false;
            etBudget.setError("Wajib diisi");
        }
        return isValid;
    }


}
