package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogActivity(View view) {
        Intent tolog = new Intent(this, LogActivity.class);
        startActivity(tolog);
    }

    public void goToNormalActivity(View view) {
        Intent toNomrmal = new Intent(this, NomalActivity.class);
        startActivity(toNomrmal);
    }

    public void gotoMechanismActivity(View view) {
        Intent toMechanism = new Intent(this, MechanismActivity.class);
        startActivity(toMechanism);
    }

    public void gotoHandlingActivity(View view) {
        Intent toHandlingActivity = new Intent( this,HandlingActivity.class);
        startActivity(toHandlingActivity);
    }
}
