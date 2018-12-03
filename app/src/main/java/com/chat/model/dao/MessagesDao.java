package com.chat.model.dao;

import com.chat.model.objects.Messages;
import com.chat.model.tables.MessagesTable;

import java.util.ArrayList;
import android.content.ContentValues;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessagesDao {

    public static Messages get(SQLiteDatabase db, int id){
        String query = "SELECT * FROM " + MessagesTable.TABLE_NAME +
                " WHERE " + MessagesTable.Columns.MESSAGE_ID + " = " + id + ";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        int contact = c.getInt(c.getColumnIndex(MessagesTable.Columns.CONTACT_ID));
        int conversation = c.getInt(c.getColumnIndex(MessagesTable.Columns.CONVERSATION_ID));
        String content = c.getString(c.getColumnIndex(MessagesTable.Columns.CONTENT));
        String geolocalization = c.getString(c.getColumnIndex(MessagesTable.Columns.GEOLOCATION));

        c.close();
        return new Messages(content, geolocalization, contact, conversation);
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