package org.baltimorecityschools.donniesmeatsyeah;

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

    Button doneBTN;
    EditText enterUsername;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterUsername = (EditText) findViewById(R.id.setUsername);
        doneBTN = (Button) findViewById(R.id.donebut);

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