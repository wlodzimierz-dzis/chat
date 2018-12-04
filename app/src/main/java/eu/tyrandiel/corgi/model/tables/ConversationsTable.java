package eu.tyrandiel.corgi.model.tables;

import android.database.sqlite.SQLiteDatabase;

public class ConversationsTable {
    public static final String TABLE_NAME = "Conversations";

    public class Columns {
        public static final String CONVERSATION_ID = "conversation_id";
        public static final String LAST_MESSAGE = "last_message";
        public static final String NAME = "name";
    }

    public static void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" +
                Columns.CONVERSATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Columns.NAME + " TEXT," +
                Columns.LAST_MESSAGE + " INTEGER," +

                "FOREIGN KEY (" + Columns.LAST_MESSAGE +
                ") REFERENCES " + MessagesTable.TABLE_NAME +
                "(" + MessagesTable.Columns.MESSAGE_ID + ") " +

                ");";
        db.execSQL(query);
    }

    public static void delete(SQLiteDatabase db) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(query);
    }
}
