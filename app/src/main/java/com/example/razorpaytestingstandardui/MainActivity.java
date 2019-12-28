package com.example.razorpaytestingstandardui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button loginButton =(Button) findViewById(R.id.loginButton);
        final EditText usernameText=(EditText) findViewById(R.id.usernameText1);
        final EditText passwordText=(EditText) findViewById(R.id.passwordText1);
        final String TAG="hello";

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             final String   username=usernameText.getText().toString();
             final String   password=passwordText.getText().toString();
                Log.e(TAG,username);
                Log.e(TAG,"praveen.gn@gmail.com");
                Log.e(TAG,password);
                Log.e(TAG,"praveen.gn");
                //final String temp = "toast1";

                if(username.equals("praveen.gn@gmail.com") && password.equals("praveen.gn")){
                     //open sucess intent
                   Intent i=new Intent(getApplicationContext(),TimelinePage.class);
                   startActivity(i);


             }
               else if (username.equals("chandra@gmail.com") && password.equals("chandra")){
                     //open sucess intent
                     Intent i=new Intent(getApplicationContext(),TimelinePage.class);
                     startActivity(i);
                 }
             else{
                // Dialog dialog = new Dialog(getApplicationContext());
                 Toast.makeText(getApplicationContext(),"username or password in incorrect Bitch!  "+username,Toast.LENGTH_LONG).show();
             }

            }
        });
    }
}
