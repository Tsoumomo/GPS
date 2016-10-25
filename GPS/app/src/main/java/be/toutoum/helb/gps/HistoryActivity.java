package be.toutoum.helb.gps;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import be.toutoum.helb.gps.database.HistoryAdapter;

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

        HistoryAdapter adapt = new HistoryAdapter(getApplicationContext());
        adapt.openWritable();

        Cursor c = adapt.getAllChar();
        String[] from = { adapt.colonne_Street, adapt.colonne_Number };
        int[] to = { android.R.id.text1, android.R.id.text2 };

        SimpleCursorAdapter sc = new SimpleCursorAdapter(
                getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, c, from, to);

        lv.setAdapter(sc);
        adapt.close();
    }

    public void intentMenu (View v){
        finish();
    }
}
