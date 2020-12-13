package com.example.healthcoach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcoach.Models.RetrieveModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
 import com.example.healthcoach.Forms.ExericseForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTrack extends AppCompatActivity {

    FloatingActionButton add;
    DatabaseReference databaseReference;
    private List<RetrieveModel> listData;
    private RecyclerView rv;
    private DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_track);

        add =findViewById(R.id.add);
        rv=(RecyclerView)findViewById(R.id.recycler);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData=new ArrayList<>();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        String personName = acct.getDisplayName();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ExerciseTrack.this, ExericseForm.class);
                startActivity(intent);
            }
        });

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("User").child(personName).child("Exercise");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        RetrieveModel l=snapshot.getValue(RetrieveModel.class);
                        listData.add(l);
                    }
                    adapter=new DataAdapter(listData);
                    rv.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}