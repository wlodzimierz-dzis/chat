package eu.tyrandiel.corgi.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import eu.tyrandiel.corgi.R;
import eu.tyrandiel.corgi.ui.ChatFragment;
import eu.tyrandiel.corgi.ui.MarkedMapFragment;

public class ConversationView extends AppCompatActivity implements View.OnClickListener {

    private final FragmentManager fm = getFragmentManager();
    private Fragment currentFragment = null;

    private boolean chatShown;
    private Button swapBtn;
    private ImageButton sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction ft = this.fm.beginTransaction();
        this.currentFragment = new MarkedMapFragment();
        ft.add(R.id.fragment_container, this.currentFragment);
        ft.commit();

        chatShown = false;

        setContentView(R.layout.activity_chat);

        swapBtn = (Button) findViewById(R.id.swap_fragment_in_conversation_button);
        swapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ConversationView.this.swapFragment(v); }
        });

        sendBtn = (ImageButton) findViewById(R.id.message_send_button);
        sendBtn.setOnClickListener(this);
    }

    public void swapFragment(View v) {
        if (chatShown) {
            swapFragmentLogic(MarkedMapFragment.class);
        } else {
            swapFragmentLogic(ChatFragment.class);
        }

        chatShown = !chatShown;
    }

    private void swapFragmentLogic(Class fragmentClass) {
        FragmentTransaction ft = this.fm.beginTransaction();
        try {
            this.currentFragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ft.replace(R.id.fragment_container, this.currentFragment);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Message would be sent now", Toast.LENGTH_SHORT).show();
    }

}
