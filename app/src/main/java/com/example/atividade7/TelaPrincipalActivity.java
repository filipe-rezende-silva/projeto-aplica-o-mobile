package com.example.atividade7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipalActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        final Button btnSair;
        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                SharedPreferences.Editor preferencias = getSharedPreferences("SP_DADOS", 0).edit();
                preferencias.clear();
                preferencias.commit();
                System.exit(1);
            }
        });
    }
}
