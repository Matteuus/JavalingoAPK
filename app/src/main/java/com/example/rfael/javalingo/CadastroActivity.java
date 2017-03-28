package com.example.rfael.javalingo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Rfael on 19/03/2017.
 */

public class CadastroActivity extends AppCompatActivity {

    EditText ctEmail, ctSenha;
    Button btCriar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);



        ctEmail = (EditText) findViewById(R.id.ctEmail);
        ctSenha = (EditText) findViewById(R.id.ctSenha);
        btCriar = (Button) findViewById(R.id.btCriar);

        firebaseAuth = FirebaseAuth.getInstance();

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.createUserWithEmailAndPassword(ctEmail.getText().toString().trim(), ctSenha.getText().toString().trim())
                        .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                              if(task.isSuccessful()){
                                  Toast.makeText(CadastroActivity.this,"Sucesso!", Toast.LENGTH_SHORT).show();
                                  firebaseAuth.signOut();
                                  Intent intent = (new Intent(CadastroActivity.this, EntradaActivity.class));
                                  startActivity(intent);

                              }
                              else{
                                  Toast.makeText(CadastroActivity.this,"Erro!", Toast.LENGTH_SHORT).show();
                              }
                            }
                        });
            }
        });

    }

}
