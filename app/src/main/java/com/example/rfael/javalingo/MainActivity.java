package com.example.rfael.javalingo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaprincipal);

        button2 = (Button) findViewById(R.id.button2);


    }

    public void agoravai(View v){
        MediaPlayer mpBtSom = MediaPlayer.create(MainActivity.this, R.raw.click);
        mpBtSom.start();
        startActivity(new Intent(MainActivity.this, EntradaActivity.class));
    }

}
