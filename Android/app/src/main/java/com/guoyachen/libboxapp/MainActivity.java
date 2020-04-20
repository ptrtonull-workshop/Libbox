package com.guoyachen.libboxapp;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
implements ActivityCompat.OnRequestPermissionsResultCallback {






    private TextView text;
    private static final int MY_PERMISSIONS_READ_EXTERNAL_STORAGE = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE))
            {
                Log.d("MainActivity","This is compat");
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSIONS_READ_EXTERNAL_STORAGE);
            }
        }
        else
        {
            //Permission has already been granted
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
                Log.d("MainActivity","This is compat");
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_READ_EXTERNAL_STORAGE);
            }
        }
        else
        {
            //Permission has already been granted
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_WIFI_STATE))
            {
                Log.d("MainActivity","This is compat");
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_WIFI_STATE},MY_PERMISSIONS_READ_EXTERNAL_STORAGE);
            }
        }
        else
        {
            //Permission has already been granted
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_SETTINGS)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_SETTINGS))

            {
                Log.d("MainActivity","This is compat");
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_SETTINGS},MY_PERMISSIONS_READ_EXTERNAL_STORAGE);
            }
        }
        else
        {
            //Permission has already been granted
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS))

            {
                Log.d("MainActivity","This is compat");
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS},MY_PERMISSIONS_READ_EXTERNAL_STORAGE);
            }
        }
        else
        {
            //Permission has already been granted
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void get_Wifi_configuration(View view) {

        text = findViewById(R.id.textView);

        ArrayList<String> connectedIP = new ArrayList<String>();



        try {
            Log.d(String.valueOf(getApplicationContext()),"have in the try");
            BufferedReader br = new BufferedReader(new FileReader("/proc/net/arp"));        //这个文件记录了所有连接在热点上的IP

            Log.d(String.valueOf(getApplicationContext()),"Get the arp document");
            String line = br.readLine();

            Log.d(String.valueOf(getApplicationContext()),"use readline");


            while (line != null) {
                String[] splitted = line.split(" +");
                if (splitted != null && splitted.length >= 4) {
                    String ip = splitted[0];
                    connectedIP.add(ip);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        text.setText(connectedIP.get(0));
    }





@Override
public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
    switch (requestCode) {
        case MY_PERMISSIONS_READ_EXTERNAL_STORAGE: {
            //if request is cancelled,the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permission was grated,yay!Do the contacts-realted task you need to do.
            }
            else
            {
                //permission denied,boo! Disable the functionality that depends on this permission.
            }
        }

    }

    return;
    }



}