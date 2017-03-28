package com.example.rfael.javalingo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaprincipal);

        imageView = (ImageView) findViewById(R.id.imageView);



    }

    public void telaPrincipal(View v) {
        setContentView(R.layout.telaprincipal);
    }

    public void começar(View v) {
        MediaPlayer mpBtSom = MediaPlayer.create(this, R.raw.click);
        mpBtSom.start();
        Intent intent = (new Intent(MainActivity.this,CadastroActivity.class));
        startActivity(intent);
    }

}
