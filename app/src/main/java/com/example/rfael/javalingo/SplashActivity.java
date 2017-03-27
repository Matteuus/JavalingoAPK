package com.example.rfael.javalingo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

public class SplashActivity extends ActionBarActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        MediaPlayer mpSom = MediaPlayer.create(this, R.raw.start);
        mpSom.start();

        Handler handler = new Handler();
        handler.postDelayed(this, 6000);
    }

    public void run() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
