package be.toutoum.helb.gps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchByKeyword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_keyword);
    }

    public void intentMap (View v){
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }

    public void intentBack (View v){
        Intent i = new Intent(this,NewDestination.class);
        startActivity(i);
    }
}
