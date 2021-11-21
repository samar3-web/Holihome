package com.samar.holihome;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.Serializable;
import java.util.HashMap;


public class DAOUsers implements Serializable {

    private DatabaseReference databaseReference;
    public DAOUsers()
    {
        FirebaseDatabase db =FirebaseDatabase.getInstance("https://my-application-8f996-default-rtdb.firebaseio.com/");
        databaseReference  = db.getReference(Users.class.getSimpleName());


    }

    public Task<Void> add(@NonNull Users us)
    {

        return databaseReference.child(us.name).setValue(us);
    }
}
