package com.example.atividade7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Declaração das variáveis da tela de login.

    private EditText edtLogin, edtSenha;
    private Button btnEntrar;
    private CheckBox cbManterConectado;
   //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        cbManterConectado = findViewById(R.id.chkbManterConectado);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String dadologin = edtLogin.getText().toString();
                String dadosenha = edtSenha.getText().toString();
                if(dadologin.equals("") || dadosenha.equals("") ) {
                    Toast.makeText(getApplicationContext(), "Os campos de login e senha devem ser preenchidos.", Toast.LENGTH_LONG).show();
                }
                else if(dadologin.equals("usuario") && dadosenha.equals("senha")){
                    if (cbManterConectado.isChecked()){
                        SharedPreferences preferencias = getSharedPreferences("SP_DADOS", 0);
                        SharedPreferences.Editor editor =preferencias.edit();
                        editor.putString("strLogin", "usuario");
                        editor.putString("strSenha", "senha");
                        editor.commit();
                    }
                    Intent intent = new Intent(LoginActivity.this, TelaPrincipalActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Autenticado com sucesso!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Usuário e/ou senha incorreto.", Toast.LENGTH_LONG).show();
                }
                }



        });
        Intent intent = new Intent(LoginActivity.this, TelaPrincipalActivity.class);
        SharedPreferences preferencias = getSharedPreferences("SP_DADOS", 0);
        if (preferencias.contains("strLogin") && preferencias.contains("strSenha")) {
            startActivity(intent);
        }




    }
}
