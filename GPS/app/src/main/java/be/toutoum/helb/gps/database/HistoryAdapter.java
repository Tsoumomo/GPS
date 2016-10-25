package be.toutoum.helb.gps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.LoginFilter;
import android.util.Log;

import be.toutoum.helb.gps.model.History;

public class HistoryAdapter {

        public static String dbName = "GPS";
        public static String tableName = "History";
        public static String colonne_id = "_id";
        public static String colonne_Number = "Number";
        public static String colonne_Street = "Street";
        public static String colonne_Town = "Town";
        public static String colonne_Country = "Country";

        private HistoryHelper helper;
        private SQLiteDatabase db;
        private Context context;

        public HistoryAdapter(Context c) {
            this.context = c;
        }

        public HistoryAdapter openWritable() {
            helper = new HistoryHelper(context, dbName, null, 1);
            db = helper.getReadableDatabase();
            return this;
        }

        public void close() {
            db.close();
            helper.close();
        }

        public long insertHistory(History h) {
            ContentValues values = new ContentValues();

            values.put(colonne_Number, h.getNum());
            values.put(colonne_Street, h.getStreet());
            values.put(colonne_Town, h.getTown());
            values.put(colonne_Country, h.getCountry());

            return db.insert(tableName, null, values);
        }

        public Cursor getAllChar() {
            String[] selectCol = {colonne_id, colonne_Number, colonne_Street, colonne_Town, colonne_Country};
            Cursor c = db.query(tableName, selectCol, null, null, null, null, null);
            return c;
        }

        public void delall() {
            db.delete(tableName, null, null);
        }

    }
