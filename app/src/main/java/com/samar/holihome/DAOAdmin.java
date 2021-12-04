package com.samar.holihome;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class DAOAdmin  implements Serializable {

    private DatabaseReference databaseReference;
    public DAOAdmin()
    {
        FirebaseDatabase db =FirebaseDatabase.getInstance("https://my-application-8f996-default-rtdb.firebaseio.com/");
        databaseReference  = db.getReference(Admin.class.getSimpleName());


    }

    public Task<Void> add(@NonNull Admin ad)
    {

        return databaseReference.child(ad.name).setValue(ad);
    }
}
