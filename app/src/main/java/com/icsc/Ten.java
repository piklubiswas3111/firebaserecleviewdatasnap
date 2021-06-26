package com.icsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icsc.Adapter.Modal;
import com.icsc.Adapter.tenAdapter;

import java.util.ArrayList;

public class Ten extends AppCompatActivity {
    private RecyclerView recyclerView;
    private tenAdapter adapter;
    private DatabaseReference databaseReference;
    private ArrayList<Modal> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);
        recyclerView = (RecyclerView) findViewById(R.id.tenrecyleview);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("user");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        adapter = new tenAdapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modal user=dataSnapshot.getValue(Modal.class);
                    data.add(user);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}