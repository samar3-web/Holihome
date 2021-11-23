package com.samar.holihome;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button Btn = findViewById(R.id.register_btn);
        final EditText InputName = findViewById(R.id.register_username_input);
        final EditText  InputEmail= findViewById(R.id.register_email_input);
        final EditText InputPassword = findViewById(R.id.register_password_input);

        DAOUsers dao =new DAOUsers();


        Btn.setOnClickListener(V -> {

            String username = InputName.getText().toString();
            String Email= InputEmail.getText().toString();
            String password = InputPassword.getText().toString();

            if (TextUtils.isEmpty(username))
            {
                Toast.makeText(RegisterActivity.this, "Please write your username...", Toast.LENGTH_SHORT).show();
            }
            else if (TextUtils.isEmpty(Email))
            {
                Toast.makeText(RegisterActivity.this, "Please write your email...", Toast.LENGTH_SHORT).show();}
            else if (TextUtils.isEmpty(password))
            {
                Toast.makeText(RegisterActivity.this, "Please write your password...", Toast.LENGTH_SHORT).show();
            }
            else{

            Users us = new Users(InputName.getText().toString(), InputEmail.getText().toString(),InputPassword.getText().toString());
            dao.add(us).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, "not inserted"+er.getMessage(), Toast.LENGTH_SHORT).show();});}




        });
    }
}
