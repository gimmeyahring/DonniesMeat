package org.baltimorecityschools.donniesmeatsyeah;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences openPreference;
    final  String sharedPreferencesFile = "org.baltimorecityschools.donavansharepreferences.sp";
    final String FIRST_OPEN_KEY = "FIRSTOPEN";

    Button doneBTN;
    EditText enterUsername;
    String username;
    View mainview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterUsername = (EditText) findViewById(R.id.setUsername);
        doneBTN = (Button) findViewById(R.id.donebut);
        mainview = findViewById(R.id.viewid);
        openPreference = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);
        if (openPreference.getBoolean(FIRST_OPEN_KEY, true)){
            enterUsername.setVisibility(View.VISIBLE);
            SharedPreferences.Editor editor = openPreference.edit();
            editor.putBoolean(FIRST_OPEN_KEY, false);
            editor.apply();


        }
        else {
            enterUsername.setVisibility(View.GONE);
            doneBTN.setText("START");

        }

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = enterUsername.getText().toString();
                if (username.length() > 13) {
                    Toast.makeText(MainActivity.this, "Username cant exceed 13 characters", Toast.LENGTH_LONG).show();
                    username = "";
                    enterUsername.setText(username);
                }
                else {
                    Intent leaveIntent;
                    leaveIntent = new Intent(MainActivity.this, MenuActivity.class);
                    leaveIntent.putExtra("usernameExtra", username);
                    startActivity(leaveIntent);
                }

            }
        });


    }
}