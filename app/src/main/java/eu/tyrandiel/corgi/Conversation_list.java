package eu.tyrandiel.corgi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import eu.tyrandiel.corgi.R;

import java.util.ArrayList;

public class Conversation_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);

        ArrayAdapter studentsAdapter = getAdapter();
        ListView listView = findViewById(R.id.student_list);
        listView.setAdapter(studentsAdapter);
    }

    private ArrayAdapter getAdapter() {
        ArrayList<Conversation> studentsList = Conversation.getExampleStudentsList();
        ArrayAdapter studentsAdapter = new ArrayAdapter(
                this,
                R.layout.activity_conversation_list,
                R.id.student_textlist,
                studentsList
        );
        return studentsAdapter;
    }
}
