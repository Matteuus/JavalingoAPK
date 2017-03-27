package com.example.rfael.javalingo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Rfael on 19/03/2017.
 */

public class CadastroActivity extends AppCompatActivity {

    EditText ctEmail, ctNome, ctSenha;
    Button btCriar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctEmail = (EditText) findViewById(R.id.ctEmail);
        ctNome = (EditText) findViewById(R.id.ctNome);
        ctSenha = (EditText) findViewById(R.id.ctSenha);
        btCriar = (Button) findViewById(R.id.btCriar);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl("https://javalingo-cb080.firebaseio.com/");

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mChild = databaseReference.push();
                mChild.child("Nome").setValue(ctNome.getText().toString().trim());
                mChild.child("Email").setValue(ctEmail.getText().toString().trim());
                mChild.child("Senha").setValue(ctSenha.getText().toString().trim());
                startActivity(new Intent(CadastroActivity.this, MainActivity.class));
            }
        });

    }

}
