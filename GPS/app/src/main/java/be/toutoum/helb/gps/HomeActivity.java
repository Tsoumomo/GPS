package be.toutoum.helb.gps;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"ufonts.com_old-english-text-mt.ttf") ;
        TextView myTextview = (TextView) findViewById(R.id.tvBookmark);
        TextView myTextview1 = (TextView) findViewById(R.id.textViewHistorique);
        TextView myTextview2 = (TextView) findViewById(R.id.textViewNouveau);
        myTextview.setTypeface(myTypeface);
        myTextview1.setTypeface(myTypeface);
        myTextview2.setTypeface(myTypeface);
    }

    public void intentFavoris (View v){
        Intent i = new Intent(this,BookmarkActivity.class);
        startActivity(i);
    }

    public void intentHistorique (View v){
        Intent i = new Intent(this,HistoryActivity.class);
        startActivity(i);
    }

    public void intentNouveau (View v){
        Intent i = new Intent(this,NewDestination.class);
        startActivity(i);
    }
}
