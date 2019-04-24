package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.voiceit.voiceit2.VoiceItAPI2;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

public class Authente extends AppCompatActivity {

    String username="";
    String value="";
    TextView location;
    JSONArray loc;
    private VoiceItAPI2 myVoiceIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authente);
        Intent created=getIntent();
        username=created.getStringExtra("userid");
        TextView mtextuser=findViewById(R.id.usernametext);
        mtextuser.setText( "Welcome "+username);




    }

    public void newenrollment(View view)
    {

        startActivity(new Intent(Authente.this,StudentEnrollment.class));
        finish();
    }


}
