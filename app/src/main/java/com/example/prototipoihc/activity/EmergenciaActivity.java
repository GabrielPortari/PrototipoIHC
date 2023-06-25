package com.example.prototipoihc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.prototipoihc.R;

public class EmergenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
        Button botaoVoltar = findViewById(R.id.button_voltar_emergencia);
        ImageView imageView1 = findViewById(R.id.imageView_BOMBEIROS);
        ImageView imageView2 = findViewById(R.id.imageView_DEFESACIVIL);
        ImageView imageView3 = findViewById(R.id.imageView_DELEGMULHER);
        ImageView imageView4 = findViewById(R.id.imageView_POLICIA);
        ImageView imageView5 = findViewById(R.id.imageView_PRF);
        ImageView imageView6 = findViewById(R.id.imageView_PROCON);
        ImageView imageView7 = findViewById(R.id.imageView_SAMU);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA OS BOMBEIROS!", Toast.LENGTH_SHORT).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA A DEFESA CIVIL!", Toast.LENGTH_SHORT).show();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA A DELEGACIA DA MULHER!", Toast.LENGTH_SHORT).show();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA A POLICIA!", Toast.LENGTH_SHORT).show();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA A POLICIA RODOVIARIA FEDERAL!", Toast.LENGTH_SHORT).show();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA O PROCON!", Toast.LENGTH_SHORT).show();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "LIGANDO PARA O SAMU!", Toast.LENGTH_SHORT).show();
            }
        });
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}