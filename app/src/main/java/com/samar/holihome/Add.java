package com.samar.holihome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {
    private Button AddHome;
    private Button AddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        AddHome = (Button) findViewById(R.id.add_h);
        AddUser = (Button) findViewById(R.id.add_u);

        AddHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(Add.this,AddHomeAdmin.class);
                startActivity(intent);
            }
        });


        AddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(Add.this,AddUser.class);
                startActivity(intent);
            }
        });






}
}
