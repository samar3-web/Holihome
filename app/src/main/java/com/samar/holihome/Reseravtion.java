package com.samar.holihome;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samar.holihome.model.ClientInfo;


public class Reseravtion extends AppCompatActivity {

    private EditText ClientNameEdt, ClientPhoneEdt, ClientDateEdt;
    private Button sendDatabtn;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    ClientInfo clientInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reseravtion);

        // initializing our edittext and button
        ClientNameEdt = findViewById(R.id.idClientName);
        ClientPhoneEdt = findViewById(R.id.idClientPhoneNumber);
        ClientDateEdt = findViewById(R.id.idClientDate);
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("ClientInfo");

        // initializing our object
        // class variable.
        clientInfo = new ClientInfo();

        sendDatabtn = findViewById(R.id.idBtnSendData);

        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = ClientNameEdt.getText().toString();
                String phone = ClientPhoneEdt.getText().toString();
                String date = ClientDateEdt.getText().toString();

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(date)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(Reseravtion.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(name, phone, date);
                }
                Intent i = new Intent(Reseravtion.this,MainActivity.class);
                startActivity(i);
            }
        });
        
    }

    private void addDatatoFirebase(String name, String phone, String date) {

        //set data on our project class
        clientInfo.setClientName(name);
        clientInfo.setClientContactNumber(phone);
        clientInfo.setClientDate(date);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(clientInfo);

                // after adding this data we are showing toast message.
                Toast.makeText(Reseravtion.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(Reseravtion.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });

    }
}