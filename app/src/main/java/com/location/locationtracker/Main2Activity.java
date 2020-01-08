package com.location.locationtracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "check";
    ListView listView;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();

    private DatabaseReference mGetReference = mDatabase.getReference().child("Saved Locations");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.list);
        Button btndelete = findViewById(R.id.delete);
        Button btnmap = findViewById(R.id.viewmap);


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

       // listView.setAdapter(arrayAdapter);
        mGetReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();

                    for (String key : dataMap.keySet()){

                        Object data = dataMap.get(key);

                        try{
                            HashMap<String, Object> userData = (HashMap<String, Object>) data;
                           Log.d(TAG, String.valueOf(userData.get("name")));
                            //Log.d(TAG, String.valueOf(userData.get("latitude")));
                            //Log.d(TAG, String.valueOf(userData.get("longitude")));


                            String value = "Location : "+String.valueOf(userData.get("name")) +" \t ("+String.valueOf(userData.get("latitude"))
                                            +","+String.valueOf(userData.get("longitude"))+")";
                            arrayList.add(value);
                            Log.d(TAG, String.valueOf(arrayList.size()));
                            listView.setAdapter(arrayAdapter);
                            arrayAdapter.notifyDataSetChanged();
                           // LocationDetails l = new LocationDetails(String.valueOf(userData.get("name")),Double.valueOf()String.valueOf(userData.get("longitude")),(userData.get("latitude")));



                          //  User mUser = new User((String) userData.get("name"), (int) (long) userData.get("age"));
                           // addTextToView(.getName() + " - " + Integer.toString(mUser.getAge()));

                        }catch (ClassCastException cce){

// If the object can’t be casted into HashMap, it means that it is of type String.

                            try{

                                String mString = String.valueOf(dataMap.get(key));
                                //addTextToView(mString);

                            }catch (ClassCastException cce2){

                            }
                        }

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*databaseReference = FirebaseDatabase.getInstance().getReference("Saved Locations");
        listView = (ListView) findViewById(R.id.list);

         arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( @NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class).toString();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
                Log.d(TAG, String.valueOf(arrayList.size()));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s){}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

final LocationDetails locationDetails = new LocationDetails();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                String temp = arrayList.get(position).substring(10,arrayList.get(position).indexOf('('));
                locationDetails.setName(temp.trim());

                Log.d(TAG,"click"+temp.trim());
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String str = locationDetails.getName();

                if (str==null){

                    Toast.makeText(Main2Activity.this,"Please select Location",Toast.LENGTH_SHORT).show();
                }
                else {

                    FirebaseDatabase.getInstance().getReference().child("Saved Locations").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            FirebaseDatabase.getInstance().getReference().child("Saved Locations").child(str).removeValue();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(Main2Activity.this,"Deleted Location Successfully !",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }
            }
        });

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String str = locationDetails.getName();

                if (str==null){

                    Toast.makeText(Main2Activity.this,"Please select Location",Toast.LENGTH_SHORT).show();
                }
                else {
                   // Double la =

                }
            }
        });



    }
}
