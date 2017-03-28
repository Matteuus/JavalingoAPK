package com.example.rfael.javalingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by mateus on 28/03/2017.
 */

public class EntradaActivity extends AppCompatActivity {

    private EditText ctEmailUsuario;
    private EditText senha;
    private FirebaseAuth firebaseAuth;
    private Button btLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrada);


        ctEmailUsuario = (EditText) findViewById(R.id.ctLogarEmail);
        senha = (EditText) findViewById(R.id.ctLogarSenha);
        btLogar = (Button) findViewById(R.id.btLogar);
        firebaseAuth = FirebaseAuth.getInstance();


        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(ctEmailUsuario.getText().toString().trim(),senha.getText().toString().trim())
                        .addOnCompleteListener(EntradaActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(EntradaActivity.this,"Bem - Vindo!", Toast.LENGTH_SHORT).show();
                                    Intent intent = (new Intent(EntradaActivity.this, JogoActivity.class));
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(EntradaActivity.this,"Usuario Inexistente!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
