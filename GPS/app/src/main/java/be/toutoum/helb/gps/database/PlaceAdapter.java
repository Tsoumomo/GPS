package be.toutoum.helb.gps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import be.toutoum.helb.gps.model.Place;

public class PlaceAdapter {
    public static String dbName = "GPS";
    public static String tableName = "places";
    public static String colonne_id = "_id";
    public static String colonne_nickname = "Nickname";
    public static String colonne_longitude = "Longitude";
    public static String colonne_latitude = "Latitude";
    public static String colonne_num = "Number";
    public static String colonne_street = "Street";
    public static String colonne_town = "Town";
    public static String colonne_country = "Country";
    public static String colonne_type = "Type";

    private PlaceHelper helper;
    private SQLiteDatabase db;
    private Context context;

    public PlaceAdapter(Context c) {
        this.context = c;
    }

    public PlaceAdapter openWritable() {
        helper = new PlaceHelper(context, dbName, null, 1);
        db = helper.getReadableDatabase();
        return this;
    }

    public void close() {
        db.close();
        helper.close();
    }

    public long insertByAdress(Place p) {
        ContentValues values = new ContentValues();

        values.put(colonne_num, p.getNum());
        values.put(colonne_street, p.getStreet());
        values.put(colonne_town, p.getTown());
        values.put(colonne_country, p.getCountry());
        values.put(colonne_type, p.getType());

        return db.insert(tableName, null, values);
    }

    public long insertByQRCode(Place p) {
        ContentValues values = new ContentValues();

        values.put(colonne_nickname, p.getNickname());
        values.put(colonne_longitude, p.getLongitude());
        values.put(colonne_latitude, p.getLatitude());
        values.put(colonne_num, p.getNum());
        values.put(colonne_street, p.getStreet());
        values.put(colonne_town, p.getTown());
        values.put(colonne_country, p.getCountry());
        values.put(colonne_type, p.getType());

        return db.insert(tableName, null, values);
    }

    public ArrayList<Place> getAllBookmark(){
        String query = "Select * FROM " + tableName + " WHERE " + colonne_type + " =  0";

        //SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Place> list = new ArrayList<Place>();

        Place place = new Place();

        while(cursor.moveToNext()){
            place.setId(Integer.parseInt(cursor.getString(0)));
            place.setNickname(cursor.getString(1));
            place.setLongitude(Double.parseDouble(cursor.getString(2)));
            place.setLatitude(Double.parseDouble(cursor.getString(3)));
            place.setNum(Integer.parseInt(cursor.getString(4)));
            place.setStreet(cursor.getString(5));
            place.setTown(cursor.getString(6));
            place.setCountry(cursor.getString(7));
            list.add(place);
        }

        cursor.close();
        //db.close();
        return list;
    }

    public ArrayList<Place> getAllHistory(){
        String query = "Select * FROM " + tableName + " WHERE " + colonne_type + " =  1";

        //SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Place> list = new  ArrayList<Place>();

        Place place = new Place();

        while(cursor.moveToNext()){
            place.setId(Integer.parseInt(cursor.getString(0)));
            place.setNum(Integer.parseInt(cursor.getString(4)));
            place.setStreet(cursor.getString(5));
            place.setTown(cursor.getString(6));
            place.setCountry(cursor.getString(7));
            list.add(place);
        }

        cursor.close();
        //db.close();
        return list;
    }

    public void delall() {
        db.delete(tableName, null, null);
    }
}
