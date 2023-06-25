package com.example.prototipoihc.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.prototipoihc.R;
import com.example.prototipoihc.adapter.Adapter;
import com.example.prototipoihc.objects.Remedio;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INTENT BOTAO ADICIONAR
        ImageView botaoAdicionar = findViewById(R.id.imageAdiciona);

        Intent intentAdd = new Intent(this, AdicionarActivity.class);
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAdd);
            }
        });
        // FIM INTENT BOTAO ADICIONAR

        //INTENT BOTAO REMOVER
        ImageView botaoRemover = findViewById(R.id.imageRemove);

        Intent intentRemove = new Intent(this, RemoverActivity.class);
        botaoRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRemove);
            }
        });
        // FIM INTENT BOTAO REMOVER

        //INTENT BOTAO EDITAR
        ImageView botaoEdit = findViewById(R.id.imageEdit);

        Intent intentEdit = new Intent(this, EditarActivity.class);
        botaoEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEdit);
            }
        });
        // FIM INTENT BOTAO REMOVER

        //INTENT BOTAO AJUDA
        Button botaoAjuda = findViewById(R.id.buttonAjuda);

        Intent intentAjuda = new Intent(this, AjudaActivity.class);
        botaoAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAjuda);
            }
        });
        // FIM INTENT BOTAO AJUDA

        //INTENT BOTAO EMERGENCIA
        Button botaoEmergencia = findViewById(R.id.buttonEmergencia);
        Intent intentEmergencia = new Intent(this, EmergenciaActivity.class);
        botaoEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEmergencia);
            }
        });
        // FIM INTENT BOTAO EMERGENCIA

        //CRIAÇÃO DO RECYCLER VIEW
        RecyclerView recyclerRemedios = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerRemedios.setLayoutManager(linearLayout);
        recyclerRemedios.setAdapter(new Adapter(criaRemedio()));
        //FIM DA CRIAÇÃO DO RECYCLER VIEW
    }

    private List<Remedio> criaRemedio(){
        return Arrays.asList(
                new Remedio("Benzetacil", "Injeção", 6, 0),
                new Remedio("Dipirona", "Gotas", 6, 15),
                new Remedio("Placebo", "Pílula", 7, 00),
                new Remedio("Dorflex", "Cápsula", 8, 30),
                new Remedio("Benzetacil", "Injeção", 9, 0),
                new Remedio("Dipirona", "Gotas", 9, 15),
                new Remedio("Placebo", "Pílula", 9, 50),
                new Remedio("Dorflex", "Cápsula", 10, 30),
                new Remedio("Benzetacil", "Injeção", 11, 5),
                new Remedio("Dipirona", "Gotas", 12, 15),
                new Remedio("Placebo", "Pílula", 14, 00),
                new Remedio("Benzetacil", "Injeção", 13, 30),
                new Remedio("Dipirona", "Gotas", 14, 15),
                new Remedio("Placebo", "Pílula", 16, 00),
                new Remedio("Dorflex", "Cápsula", 16, 30),
                new Remedio("Benzetacil", "Injeção", 17, 30),
                new Remedio("Dipirona", "Gotas", 18, 15),
                new Remedio("Placebo", "Pílula", 19, 00),
                new Remedio("Dorflex", "Cápsula", 19, 30),
                new Remedio("Benzetacil", "Injeção", 20, 30),
                new Remedio("Dipirona", "Gotas", 21, 15),
                new Remedio("Placebo", "Pílula", 22, 00),
                new Remedio("Dorflex", "Cápsula", 22, 30)
        );
    }
}