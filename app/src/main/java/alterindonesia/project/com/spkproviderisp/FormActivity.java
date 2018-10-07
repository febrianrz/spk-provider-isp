package alterindonesia.project.com.spkproviderisp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

    EditText etNama, etBudget, etDomisili;

    Button btnSubmit;
    Integer budgetId = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Perhitungan");

        etNama      = (EditText) findViewById(R.id.etName);
        etBudget    = (EditText) findViewById(R.id.etPrice);
        etDomisili  = (EditText) findViewById(R.id.etDomisili);
        btnSubmit   = (Button) findViewById(R.id.btnSubmit);


        etBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[]  options = {"Rp200.000 - Rp300.000",
                        "Rp300.000 - Rp400.000","Rp400.000 - Rp500.000","> Rp500.000"};
                AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
                builder.setTitle("Harga Tersedia");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                        etBudget.setText(options[item]);
                        budgetId = (item+1);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){

                    Intent intent = new Intent(FormActivity.this,PaketListActivity.class);
                    intent.putExtra("type","form");
                    intent.putExtra("domisili",etDomisili.getText().toString());
                    intent.putExtra("budget",budgetId);
                    startActivity(intent);
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
        if(TextUtils.isEmpty(etDomisili.getText().toString())){
            isValid = false;
            etDomisili.setError("Wajib diisi");
        }
        return isValid;
    }


}
