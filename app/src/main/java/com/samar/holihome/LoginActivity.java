package com.samar.holihome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity{

    private Button joinNowButton;

    private EditText  InputPassword;
    private EditText  InputName;

    private Button LoginButton;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        joinNowButton = (Button) findViewById(R.id.main_join_now_btn);
        LoginButton = (Button) findViewById(R.id.login_btn);
        InputName = (EditText) findViewById(R.id.inputname);

        InputPassword = (EditText) findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = InputName.getText().toString();
                String password = InputPassword.getText().toString();

                if (TextUtils.isEmpty(username))
                {
                    Toast.makeText(LoginActivity.this, "Please write your username...", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginActivity.this, "Please write your password...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loadingBar.setTitle("Login Account");
                    loadingBar.setMessage("Please wait, while we are checking the credentials.");
                    loadingBar.setCanceledOnTouchOutside(true);
                    loadingBar.show();
                    AllowAccessToAccount(username, password);

                }






            }

        });



        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }







    private void AllowAccessToAccount(final String username, final String password){


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance("https://my-application-8f996-default-rtdb.firebaseio.com/").getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Users usersData = dataSnapshot.child(username).child(password).getValue(Users.class);
                if (dataSnapshot.child("Users").hasChild(username))
                {


                    Toast.makeText(LoginActivity.this, "Account with this " + username + " username exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    final String getpass = dataSnapshot.child("Users").child(username).child("password").getValue(String.class);
                    if (getpass.equals(password))
                    {
                        Toast.makeText(LoginActivity.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Prevalent.currentOnlineUser = usersData;
                        startActivity(intent);}
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                    }

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Account with this " + username + " email do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }


            }





            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
