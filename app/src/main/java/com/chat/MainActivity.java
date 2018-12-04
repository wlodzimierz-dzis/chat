package com.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter studentsAdapter = setAdapter();
        ListView listView = findViewById(R.id.chatsList);
        listView.setAdapter(studentsAdapter);
    }
    private ArrayAdapter setAdapter() {
        String chats[] = {"Bartosz", "Tomasz", "Konrad"};
        ArrayList<String> chatsList = new ArrayList<String>();
        chatsList.addAll( Arrays.asList(chats) );
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_main, R.id.chat_textlist, chatsList);

        return adapter;
    }

    public void onItemClick( View view) {
        Intent i = new Intent(MainActivity.this, chat.class);
        startActivity(i);
    }
}
