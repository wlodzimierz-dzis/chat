package com.chat.model.tables;

import android.database.sqlite.SQLiteDatabase;

public class ConvMembersTable {
    public static final String TABLE_NAME = "ConvMembersTable";

    public class Columns {
        public static final String CM_ID = "cm_id";
        public static final String CONVERSATION_ID = "conversation_id";
        public static final String CONTACT_ID = "contact_id";
    }

    public static void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" +
                Columns.CM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Columns.CONVERSATION_ID + " INTEGER," +
                Columns.CONTACT_ID + " INTEGER," +

                "FOREIGN KEY (" + Columns.CONTACT_ID +
                ") REFERENCES " + ContactsTable.TABLE_NAME +
                "(" + ContactsTable.Columns.CONTACT_ID + "), " +

                "FOREIGN KEY (" + Columns.CONVERSATION_ID +
                ") REFERENCES " + ConversationsTable.TABLE_NAME +
                "(" + ConversationsTable.Columns.CONVERSATION_ID + ") " +

                ");";
        db.execSQL(query);
    }

    public static void delete(SQLiteDatabase db) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(query);
    }
}

