package org.baltimorecityschools.donniesmeatsyeah;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SandwichActivity extends AppCompatActivity {

    RadioGroup meatgroup;
    RadioButton chickenbutton;
    RadioButton hambutton;
    RadioButton turkeybutton;
    Button minusbutton;
    TextView quantitytextview;
    Button plusbutton;
    Button submitbutton;
    TextView subtotaltextview;
    Button addorderbutton;
    int quantity;
    String meattype;
    int meatid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        quantity = 1;
        meatgroup = findViewById(R.id.meatRGRP);
        chickenbutton = findViewById(R.id.chickenbut);
        hambutton = findViewById(R.id.hambut);
        turkeybutton = findViewById(R.id.turkeybut);
        minusbutton = findViewById(R.id.minusBTN);
        quantitytextview = findViewById(R.id.quantityTV);
        plusbutton = findViewById(R.id.plusBTN);
        submitbutton = findViewById(R.id.submitBTN);
        subtotaltextview = findViewById(R.id.subtotalTV);
        addorderbutton = findViewById(R.id.addOrderBTN);

        addorderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = Integer.valueOf(quantitytextview.getText().toString());
                meatid = meatgroup.getCheckedRadioButtonId();
                if (meatid == R.id.chickenbut){
                    meattype = "chicken";
                }
                else if (meatid == R.id.hambut){
                    meattype = "ham";
                }
                else if (meatid == R.id.turkeybut){
                    meattype = "turkey";
                }

                Sandwich sandwich1 = new Sandwich(meattype,"barbecu", false, false, quantity);

                subtotaltextview.setText("Subtotal: $" + sandwich1.getPrice());
                Log.d("Order Has Been Created", sandwich1.toString());

            }
        });
        plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantitytextview.setText(String.valueOf(quantity));
            }
        });
        minusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0){
                    quantity--;
                    quantitytextview.setText(String.valueOf(quantity));
                }

            }
        });


    }
}