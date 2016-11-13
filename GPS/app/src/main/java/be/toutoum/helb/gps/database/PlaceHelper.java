package be.toutoum.helb.gps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlaceHelper extends SQLiteOpenHelper {

    private final String CREAT_REQUEST = "CREATE TABLE "
            + PlaceAdapter.tableName + " ( "
            + PlaceAdapter.colonne_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PlaceAdapter.colonne_nickname + " TEXT NOT NULL, "
            + PlaceAdapter.colonne_longitude + " TEXT NOT NULL, "
            + PlaceAdapter.colonne_latitude + " TEXT NOT NULL, "
            + PlaceAdapter.colonne_num + " INT NULL, "
            + PlaceAdapter.colonne_street + " TEXT NOT NULL, "
            + PlaceAdapter.colonne_town + " TEXT NOT NULL, "
            + PlaceAdapter.colonne_country + " TEXT NOT NULL, "
            + PlaceAdapter.colonne_type + " INT NULL ) ";

    public PlaceHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PlaceAdapter.tableName);
        onCreate(db);
    }
}
