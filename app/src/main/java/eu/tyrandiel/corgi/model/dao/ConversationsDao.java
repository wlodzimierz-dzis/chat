package eu.tyrandiel.corgi.model.dao;

import eu.tyrandiel.corgi.model.objects.Messages;
import eu.tyrandiel.corgi.model.tables.MessagesTable;

import java.util.ArrayList;
import android.content.ContentValues;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ConversationsDao {

    public static ArrayList<Messages> get(SQLiteDatabase db, int id){
        String query = "SELECT * FROM " + MessagesTable.TABLE_NAME +
                " WHERE " + MessagesTable.Columns.CONVERSATION_ID + " = " + id + ";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        ArrayList<Messages> messages = new ArrayList<>();
        do {
            int contact_id = c.getInt(c.getColumnIndex(MessagesTable.Columns.CONTACT_ID));
            String content = c.getString(c.getColumnIndex(MessagesTable.Columns.CONTACT_ID));
            String geolocation = c.getString(c.getColumnIndex(MessagesTable.Columns.GEOLOCATION));

            Messages message = new Messages(content, geolocation, id, contact_id);
            message.setId(c.getInt(c.getColumnIndex(MessagesTable.Columns.MESSAGE_ID)));
            messages.add(message);

        } while (c.moveToNext());
        c.close();

        return messages;
    }

    public static void insert(SQLiteDatabase db, Messages message) {
        ContentValues values = new ContentValues();
        values.put(MessagesTable.Columns.CONTACT_ID, message.getContact());
        values.put(MessagesTable.Columns.CONVERSATION_ID, message.getConversation());
        values.put(MessagesTable.Columns.CONTENT, message.getContent());
        values.put(MessagesTable.Columns.GEOLOCATION, message.getGeolocation());

        int id = (int) db.insert(MessagesTable.TABLE_NAME, null, values);
        message.setId(id);
    }

    public static void update(SQLiteDatabase db, Messages model) {}
    public static void delete(SQLiteDatabase db, int id) {}
}