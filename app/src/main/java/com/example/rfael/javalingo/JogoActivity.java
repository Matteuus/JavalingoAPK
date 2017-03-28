package com.example.rfael.javalingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by mateus on 28/03/2017.
 */

public class JogoActivity extends AppCompatActivity {

    private Button btLogout;
    private FirebaseAuth firebaseAuth;
    private TextView rtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo);


        btLogout = (Button) findViewById(R.id.btLogout);
        rtEmail = (TextView) findViewById(R.id.rtEmail);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            Log.i("VerificaUsuario", "usuario esta logado");
            rtEmail.setText(firebaseAuth.getCurrentUser().getEmail());
        }else{
            Log.i("VerificaUsuario", "usuario nao esta logado");
        }


        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent = (new Intent(JogoActivity.this, EntradaActivity.class));
                startActivity(intent);
            }

        });
    }
}
