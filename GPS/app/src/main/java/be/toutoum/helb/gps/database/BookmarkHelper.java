package be.toutoum.helb.gps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookmarkHelper extends SQLiteOpenHelper {

    private final String CREAT_REQUEST = "CREATE TABLE "
            + BookMarkAdapter.tableName + " ( "
            + BookMarkAdapter.colonne_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + BookMarkAdapter.colonne_Name + " TEXT NOT NULL, "
            + BookMarkAdapter.colonne_Latitude + " TEXT NOT NULL, "
            + BookMarkAdapter.colonne_Longitude + " TEXT NOT NULL )";

    public BookmarkHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + BookMarkAdapter.tableName + ";");
        onCreate(db);
    }
}