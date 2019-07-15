package com.qi0developerment.snippetsdecodigo_checkappintalled_java;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCheck = findViewById(R.id.btCheck);
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPackageAvailable("com.google.android.apps.maps")){
                    Toast.makeText(MainActivity.this, "App Instaled", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "App Missing", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean isPackageAvailable(String packgageName){
        boolean avaliable = true;

        try {
            getPackageManager().getPackageInfo(packgageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            avaliable = false;
        }

        return avaliable;
    }
}
