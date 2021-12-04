package com.samar.holihome;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samar.holihome.adapter.DiscountedProductAdapter;
import com.samar.holihome.adapter.RecentlyViewedAdapter;
import com.samar.holihome.model.DiscountedProducts;
import com.samar.holihome.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class LoginAdmin extends AppCompatActivity {

    private EditText InputPassword;
    private String  InputName;

    private Button LoginButton;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputName = "admin";
        DAOAdmin dao =new DAOAdmin();

        InputPassword = (EditText) findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);
        Admin ad = new Admin("admin","pass");
        dao.add(ad);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = InputName;
                String password = InputPassword.getText().toString();

                if (TextUtils.isEmpty(username))
                {
                    Toast.makeText(LoginAdmin.this, "Please write your username...", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginAdmin.this, "Please write your password...", Toast.LENGTH_SHORT).show();
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





    }







    private void AllowAccessToAccount(final String username, final String password){


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance("https://my-application-8f996-default-rtdb.firebaseio.com/").getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child("Admin").hasChild(username))
                {


                    final String getpass = dataSnapshot.child("Admin").child(username).child("password").getValue(String.class);
                    if (password.equals("pass"))
                    {
                        Toast.makeText(LoginAdmin.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                        Intent intent = new Intent(LoginAdmin.this, MainActivityAdmin.class);
                        startActivity(intent);}
                    else
                    {
                        Toast.makeText(LoginAdmin.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                    }

                }
                else
                {
                    Toast.makeText(LoginAdmin.this, "Account with this " + username + " email do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }


            }





            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }}