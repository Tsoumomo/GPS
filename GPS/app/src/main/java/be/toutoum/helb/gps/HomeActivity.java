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
        TextView myTextview1 = (TextView) findViewById(R.id.tvHistory);
        TextView myTextview2 = (TextView) findViewById(R.id.tvNew);
        myTextview.setTypeface(myTypeface);
        myTextview1.setTypeface(myTypeface);
        myTextview2.setTypeface(myTypeface);
    }

    public void intentBookmark (View v){
        Intent i = new Intent(this,BookmarkActivity.class);
        startActivity(i);
    }

    public void intentHistory (View v){
        Intent i = new Intent(this,HistoryActivity.class);
        startActivity(i);
    }

    public void intentNew (View v){
        Intent i = new Intent(this,NewDestination.class);
        startActivity(i);
    }
}
