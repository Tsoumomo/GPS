package be.toutoum.helb.gps;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

import be.toutoum.helb.gps.database.PlaceAdapter;
import be.toutoum.helb.gps.model.Place;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView lv = (ListView) findViewById(R.id.lvHistory);

        PlaceAdapter adapt = new PlaceAdapter(getApplicationContext());
        adapt.openWritable();

        List<Place> list = adapt.getAllBookmark();

        adapt.close();

        ArrayAdapter<Place> arrayAdapter =
                new ArrayAdapter<Place>(this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(arrayAdapter);
    }

    public void intentMenu (View v){
        finish();
    }
}
