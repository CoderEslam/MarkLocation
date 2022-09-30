package com.doubleclick.marklocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name, phone, phoneN, lat, lag, address;
    private DatabaseReference reference;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference = FirebaseDatabase.getInstance().getReference();
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        phoneN = findViewById(R.id.phoneN);
        lat = findViewById(R.id.lat);
        lag = findViewById(R.id.lag);
        address = findViewById(R.id.address);
        done = findViewById(R.id.done);

        done.setOnClickListener(view -> {
            if (!name.getText().toString().equals("") && !phone.getText().toString().equals("") && !lat.getText().toString().equals("") && !lag.getText().toString().equals("") && !address.getText().toString().equals(""))
                uplaod(name.getText().toString(), phone.getText().toString(), phoneN.getText().toString(), lat.getText().toString(), lag.getText().toString(), address.getText().toString());
        });

        findViewById(R.id.maps).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MapsActivity.class));
        });
    }

    private void uplaod(String Name, String Phone, String PhoneN, String Lat, String Lag, String Address) {
        HashMap<String, Object> map = new HashMap<>();
        String id = reference.push().getKey() + System.currentTimeMillis();
        map.put("name", Name);
        map.put("phone", Phone + "\n" + phoneN);
        map.put("lat", Lat);
        map.put("lag", Lag);
        map.put("address", Address);
        map.put("id", id);
        reference.child("Location").child(id).updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                name.setText("");
                phone.setText("");
                phoneN.setText("");
                lat.setText("");
                lag.setText("");
                address.setText("");
            }
        });
    }
}