package alterindonesia.project.com.spkproviderisp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
