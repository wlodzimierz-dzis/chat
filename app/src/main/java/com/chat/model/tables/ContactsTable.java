package com.chat.model.tables;

import android.database.sqlite.SQLiteDatabase;

public class ContactsTable {
    public static final String TABLE_NAME = "ContactsTable";

    public class Columns {
        public static final String CONTACT_ID = "contact_id";
        public static final String PHONEBOOK_REF = "phonebook_ref";
        public static final String USER_ID_SERVER = "user_id_server";
    }

    public static void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" +
                Columns.CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Columns.PHONEBOOK_REF + " INTEGER," +
                Columns.USER_ID_SERVER + " INTEGER" +

                ");";
        db.execSQL(query);
    }

    public static void delete(SQLiteDatabase db) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(query);
    }
}
