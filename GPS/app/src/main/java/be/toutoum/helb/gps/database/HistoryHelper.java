package be.toutoum.helb.gps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HistoryHelper extends SQLiteOpenHelper {

    private final String CREAT_REQUEST = "CREATE TABLE "
            + HistoryAdapter.tableName + " ( "
            + HistoryAdapter.colonne_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HistoryAdapter.colonne_Number + " INTEGER NULL, "
            + HistoryAdapter.colonne_Street + " TEXT NOT NULL, "
            + HistoryAdapter.colonne_Town + " TEXT NOT NULL, "
            + HistoryAdapter.colonne_Country + " TEXT NOT NULL )";

    public HistoryHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + HistoryAdapter.tableName + ";");
        onCreate(db);
    }
}

