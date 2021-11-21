package com.samar.holihome;

import android.os.Bundle;
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

            Users us = new Users(InputName.getText().toString(), InputEmail.getText().toString(),InputPassword.getText().toString());
            dao.add(us).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, "not inserted"+er.getMessage(), Toast.LENGTH_SHORT).show();});




        });
    }
}
