package be.toutoum.helb.gps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import be.toutoum.helb.gps.model.Bookmark;

public class BookMarkAdapter {

    public static String dbName = "GPS";
    public static String tableName = "Bookmark";
    public static String colonne_id = "_id";
    public static String colonne_Name = "Nom";
    public static String colonne_Latitude = "Latitude";
    public static String colonne_Longitude = "Longitude";

    private BookmarkHelper helper;
    private SQLiteDatabase db;
    private Context context;

    public BookMarkAdapter(Context c) {
        this.context = c;
    }

    public BookMarkAdapter openWritable() {
        helper = new BookmarkHelper(context, dbName, null, 1);
        db = helper.getReadableDatabase();
        return this;
    }

    public void close() {
        db.close();
        helper.close();
    }

    public long insertBoorkmark(Bookmark b) {
        ContentValues values = new ContentValues();

        values.put(colonne_Name, b.getName());
        values.put(colonne_Latitude, b.getLatitude());
        values.put(colonne_Longitude, b.getLongitude());

        return db.insert(tableName, null, values);
    }

    public Cursor getAllChar() {
        String[] selectCol = {colonne_id, colonne_Name, colonne_Latitude, colonne_Longitude};
        Cursor c = db.query(tableName, selectCol, null, null, null, null, null);
        return c;
    }

    public void delall() {
        db.delete(tableName, null, null);
    }
}
