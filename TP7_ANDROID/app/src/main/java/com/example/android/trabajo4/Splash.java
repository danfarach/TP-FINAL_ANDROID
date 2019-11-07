package com.example.android.trabajo4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends AppCompatActivity
{
    private TimerTask task;
    private static final long SPLASH_SCREEN_DELAY = 6000;

    private TextView t;
    private ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        i = findViewById(R.id.imageView);






        task = new TimerTask()
        {
            @Override
            public void run()
            {   // Start the next activity
                Intent Intentprincipal = new Intent (Splash.this,Login.class);
                startActivity(Intentprincipal);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


    }
}
