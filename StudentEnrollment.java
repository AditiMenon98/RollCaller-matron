package com.example.abhirami.rollcaller;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.voiceit.voiceit2.VoiceItAPI2;

import org.json.JSONObject;

import org.json.JSONException;



import cz.msebera.android.httpclient.Header;
public class StudentEnrollment extends AppCompatActivity {
    String voiceitID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enrollment);
    }
    public void voiceitenroll(View view)
    {
        EditText rolluser=(EditText)findViewById(R.id.newrollno);
        String rollno=rolluser.getText().toString();

        EditText nameuser=(EditText)findViewById(R.id.newname);
        String name=nameuser.getText().toString();

        EditText blockuser=(EditText)findViewById(R.id.newblock);
        String block=blockuser.getText().toString();

        EditText roomuser=(EditText)findViewById(R.id.newroom);
        String room=roomuser.getText().toString();

        EditText phoneuser=(EditText)findViewById(R.id.newphone);
        String phone=phoneuser.getText().toString();

        final StudentDetails newstudent=new StudentDetails();
        Room newRoom=new Room();
        newRoom.setBlock(block);
        newRoom.setRoomNo(room);
        newstudent.setRoom(newRoom);

        newstudent.setRollNo(rollno);
        newstudent.setPhoneNo(phone);
        newstudent.setName(name);

        VoiceItAPI2 myVoiceIt;
        myVoiceIt = new VoiceItAPI2("key_a6523fd2aace403c8b9c2089dd04c59c","tok_906ed07bb59b4422b3748df43733c025");




        myVoiceIt.createUser(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                voiceitID=new String(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        try {
            JSONObject voiceid = new JSONObject(voiceitID);
            voiceitID=voiceid.getString("userId");
        }
        catch(JSONException e)
        {
            Log.v("Error","JSON Object couldn't be created");
        }







        myVoiceIt.encapsulatedVoiceEnrollment(StudentEnrollment.this, voiceitID, "en-US", "Never forget tomorrow is a new day", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(StudentEnrollment.this,response.toString(),
                        Toast.LENGTH_LONG).show();

                addnewuser(newstudent);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    Log.v("JSONResult : ", errorResponse.toString());
                }
            }
        });





    }
    public void addnewuser(StudentDetails newuser){

        DatabaseReference myRef= FirebaseDatabase.getInstance().getReference();
        myRef.child("StudentDetails").child(newuser.getRollNo()).setValue(newuser);


    }

}
