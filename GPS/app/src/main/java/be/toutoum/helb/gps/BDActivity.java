package be.toutoum.helb.gps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd);

        TextView TVBD = (TextView)findViewById(R.id.BDtextView);

        Bundle bu;
        bu = getIntent().getExtras();
        TVBD.setText(bu.getString("reponse"));

    }
}
