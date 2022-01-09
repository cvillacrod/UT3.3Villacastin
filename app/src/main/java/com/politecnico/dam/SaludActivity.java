package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SaludActivity extends AppCompatActivity {

    // ArrayList for person names, email Id's and mobile numbers
    ArrayList<String> centroNames = new ArrayList<>();
    ArrayList<String> centroDireccion = new ArrayList<>();
    ArrayList<String> centroLocalidad = new ArrayList<>();
    ArrayList<String> centroTelefono = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray userArray = obj.getJSONArray("ITEMS");
            // implement for loop for getting users list data
            for (int i = 0; i < userArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = userArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                centroNames.add(userDetail.getString("NOMBRE"));
                centroDireccion.add(userDetail.getString("DIRECCION"));
                centroLocalidad.add(userDetail.getString("LOCALIDAD"));
                centroTelefono.add(userDetail.getString("TELEFONO"));

                // create a object for getting contact data from JSONObject
                //JSONObject contact = userDetail.getJSONObject("contact");
                // fetch mobile number and store it in arraylist
                //mobileNumbers.add(contact.getString("mobile"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(SaludActivity.this, centroNames, centroDireccion, centroLocalidad,centroTelefono);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            //InputStream is = getAssets().open("users_list.json");
            InputStream is = getAssets().open("CentrosSanitarios.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}
