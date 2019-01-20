package com.example.dan.googlemap;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           if(isServicesOk()) {
               init();
           }
        
    }

    private void init()
    {

        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
        MainActivity.this.finish();


    }

    public void popBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm != null) {
            fm.popBackStack();
        }
    }

    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOk: checking google services version");

        /* This is to check the availability of the program */

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS)
        {
            Log.d(TAG, "isServicesOk: Google Play Services is Online");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            Log.d(TAG, "isServicesOk: Error Occured but fixable");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else
            {
                Toast.makeText(this, "Map access denied", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}
