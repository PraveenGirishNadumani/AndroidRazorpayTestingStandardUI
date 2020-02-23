package com.example.razorpaytestingstandardui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.font.TextAttribute;

public class TimelinePage extends AppCompatActivity implements PaymentResultListener {
    final String TAG="error msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline_page);

        final ImageButton imageButton=(ImageButton) findViewById(R.id.imageButton1);
        final ImageButton imageButton1=(ImageButton) findViewById(R.id.imageButton2);
        final ImageButton imageButton2=(ImageButton) findViewById(R.id.imageButton3);


        Checkout.preload(getApplicationContext());

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"makeAmoutfor1",Toast.LENGTH_SHORT).show();
                makePayment(5000);
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"makeAout2",Toast.LENGTH_SHORT).show();
                makePayment(4000);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"makeAmount3",Toast.LENGTH_SHORT).show();
                makePayment(4050);
            }
        });
    }

    private void makePayment(int amount)
    {

        Checkout checkout=new Checkout();
        //checkout.setKeyID("rzp_test_DSfAaZAnXaWp0j");
        //checkout.setImage(R.id.imageButton1);

        final Activity activity=this;

        try{
            JSONObject options=new JSONObject();
            options.put("name","praveen");
            options.put("description","paying for the dog");
            options.put("currency","INR");
            options.put("amount",amount*100);
           Log.e(TAG,"calling checkout");
            checkout.open(activity,options);


        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG,"error in opening checkout");
        }
    }
    public void onPaymentSuccess(String razorpayPaymentID) {
        /**
         * Add your logic here for a successful payment response
         */

        Toast.makeText(getApplicationContext(),"sucess"+razorpayPaymentID,Toast.LENGTH_SHORT).show();
    }

    public void onPaymentError(int code, String response) {
        /**
         * Add your logic here for a failed payment response
         */
        Toast.makeText(getApplicationContext(),response ,Toast.LENGTH_SHORT).show();
    }
}
