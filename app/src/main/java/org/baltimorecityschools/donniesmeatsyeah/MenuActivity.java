package org.baltimorecityschools.donniesmeatsyeah;

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

public class MenuActivity extends AppCompatActivity {


    final  String sharedPreferencesFile = "org.baltimorecityschools.donavansharepreferences.sp";
    final String USERNAME_KEY = "USERNAMESAVE";

    String username;
    TextView usertxt;
    Button sandwichBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent1 = getIntent();
        username = intent1.getStringExtra("usernameExtra");
        usertxt = (TextView) findViewById(R.id.usernametext);
        usertxt.setText(username);
        sandwichBTN = findViewById(R.id.sandwichbut);

        sandwichBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaveIntent;
                leaveIntent = new Intent(MenuActivity.this, SandwichActivity.class);
                startActivity(leaveIntent);
            }
        });

    }



    
}