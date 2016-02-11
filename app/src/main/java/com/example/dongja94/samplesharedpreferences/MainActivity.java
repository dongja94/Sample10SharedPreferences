package com.example.dongja94.samplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "my_prefs";
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private static final String FIELD_USER_ID = "userId";
    private static final String FIELD_PASSWORD = "password";

    EditText idView, pwView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        idView = (EditText)findViewById(R.id.edit_userid);
        pwView = (EditText)findViewById(R.id.edit_password);

        mPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();

        Button btn = (Button)findViewById(R.id.btn_save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = idView.getText().toString();
                String password = pwView.getText().toString();
                PropertyManager.getInstance().setUserId(userid);
                PropertyManager.getInstance().setPassword(password);
//                mEditor.putString(FIELD_USER_ID, userid);
//                mEditor.putString(FIELD_PASSWORD, password);
//                mEditor.commit();
            }
        });

//        idView.setText(mPrefs.getString(FIELD_USER_ID, ""));
//        pwView.setText(mPrefs.getString(FIELD_PASSWORD,""));
        idView.setText(PropertyManager.getInstance().getUserId());
        pwView.setText(PropertyManager.getInstance().getPassword());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
