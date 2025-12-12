package org.baltimorecityschools.donniesmeatsyeah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class SandwichActivity extends AppCompatActivity {

    RadioGroup meatgroup;
    RadioButton chickenbutton;
    RadioButton hambutton;
    RadioButton turkeybutton;
    Button minusbutton;
    TextView quantitytextview, taxtextview, totaltextview;
    Button plusbutton;
    Button submitbutton;
    TextView subtotaltextview;
    Button addorderbutton;
    int quantity;
    String meattype;
    int meatid;
    double subtotal;
    double tax;
    double total;

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
        taxtextview = findViewById(R.id.taxTV);
        totaltextview = findViewById(R.id.totalTV);

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
                subtotal += sandwich1.getPrice();
                tax = subtotal * 0.06;
                subtotaltextview.setText("Subtotal: $" + subtotal);
                taxtextview.setText("Tax: $" + tax);
                total = tax + subtotal;
                totaltextview.setText("Total: $" + total);

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
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeEmail("You made a $" + total + "purchase. Enjoy the Meat! Hope you order again!\n-Donnie's Meats", "Donnie's Meat Order");
            }
        });


    }

    public void composeEmail(String body, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(intent);
    }
}