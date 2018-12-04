package com.chat.model.dao;

import com.chat.model.objects.Contacts;
import com.chat.model.tables.ContactsTable;


import android.content.ContentValues;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ContactsDao {
    public static Contacts get(SQLiteDatabase db, int id){
        String query = "SELECT * FROM " + ContactsTable.TABLE_NAME +
                " WHERE " + ContactsTable.Columns.CONTACT_ID + " = " + id + ";";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        String phonebook = c.getString(c.getColumnIndex(ContactsTable.Columns.PHONEBOOK_REF));
        String userserver = c.getString(c.getColumnIndex(ContactsTable.Columns.USER_ID_SERVER));
        c.close();
        return new Contacts(phonebook, userserver);
    }

    public static void insert(SQLiteDatabase db, Contacts contacts) {
        ContentValues values = new ContentValues();
        values.put(ContactsTable.Columns.PHONEBOOK_REF, contacts.getPhonebook());
        values.put(ContactsTable.Columns.USER_ID_SERVER, contacts.getUserServer());

        int id = (int) db.insert(ContactsTable.TABLE_NAME, null, values);
        contacts.setId(id);
    }

    public static void update(SQLiteDatabase db, Contacts model) {}
    public static void delete(SQLiteDatabase db, int id) {}
}