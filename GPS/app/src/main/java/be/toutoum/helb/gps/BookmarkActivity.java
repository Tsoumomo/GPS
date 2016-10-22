package be.toutoum.helb.gps;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import be.toutoum.helb.gps.database.BookMarkAdapter;

public class BookmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView lv = (ListView) findViewById(R.id.lvHistory);

        BookMarkAdapter adapt = new BookMarkAdapter(getApplicationContext());
        adapt.openWritable();

        Cursor c = adapt.getAllChar();
        String[] from = { adapt.colonne_Name};
        int[] to = { android.R.id.text1};

        SimpleCursorAdapter sc = new SimpleCursorAdapter(
                getApplicationContext(),
                android.R.layout.simple_expandable_list_item_2, c, from, to);

        lv.setAdapter(sc);
        adapt.close();
    }

    public void intentMenu (View v){
        finish();
    }
}
