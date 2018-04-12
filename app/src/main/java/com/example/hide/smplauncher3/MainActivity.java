package com.example.hide.smplauncher3;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;

import static android.content.pm.PackageManager.FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "smplv3";
    View changeButton,clearButton,checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        changeButton = this.findViewById(R.id.Button01);
        changeButton.setOnClickListener((android.view.View.OnClickListener) this);

     }

    public void onClick(View v){
        Intent intent = new Intent(); /* act */
        intent.setFlags(
                Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT |
                        Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK); /* */
        intent.setClassName("com.example.hide.sample3",
                "com.example.hide.sample3.MainActivity");
        PackageManager pm = getPackageManager();
        int displayid=9999;

        displayid=ActivityOptions.makeBasic().getLaunchDisplayId();
        if (false == pm.hasSystemFeature(FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS)){
            startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(-1).toBundle());
            displayid=ActivityOptions.makeBasic().getLaunchDisplayId();
        } else {
            /* startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(-1).toBundle()); /* */
            /* startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(0).toBundle()); /* */
            startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(1).toBundle()); /* */
            /* startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(2).toBundle()); /* */
            displayid=ActivityOptions.makeBasic().getLaunchDisplayId();
        }
        Log.i(TAG, "displayid =" + displayid);
    }
}
