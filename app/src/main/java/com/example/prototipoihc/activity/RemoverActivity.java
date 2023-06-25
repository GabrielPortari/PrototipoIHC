package com.example.prototipoihc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prototipoihc.R;

import java.util.ArrayList;
import java.util.Random;

public class RemoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover);
        ArrayList<String> lista_remedio = new ArrayList<>();
        lista_remedio.add("Benzetacil");
        lista_remedio.add("Dorflex");
        lista_remedio.add("Placebo");
        lista_remedio.add("Dramin");
        lista_remedio.add("Ritalina");

        //CONFIGURAÇÃO DO SPINNER
        Spinner spinner = findViewById(R.id.spinner_excluir_select);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista_remedio);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        //FIM CONFIGURAÇÃO SPINNER

        TextView nome = findViewById(R.id.text_excluir_nome);
        TextView tipo = findViewById(R.id.text_excluir_tipo);

        ArrayList<String> tipos_remedio = new ArrayList<>();
        tipos_remedio.add("Capsula");
        tipos_remedio.add("Pilula");
        tipos_remedio.add("Injeção");
        tipos_remedio.add("Gotas");
        tipos_remedio.add("Outros");

        TextView horario = findViewById(R.id.text_excluir_horario);
        ImageView imagem = findViewById(R.id.imagem_excluir);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSpinner = parent.getItemAtPosition(position).toString();
                nome.setText("Nome: " + itemSpinner); // mostra o nome do remedio

                //GERA UM TIPO ALEATORIO
                Random rand = new Random();
                int random = rand.nextInt(4);
                tipo.setText("Tipo: " + tipos_remedio.get(random));

                //GERA UMA HORA ALEATORIA
                random = rand.nextInt(23);
                String hora = "" + random;
                if(random < 10) {
                    hora = "0" + random;
                }

                //GERA UM MINUTO ALEATORIO
                random = rand.nextInt(59);
                String min = "" + random;
                if(random < 10) {
                    min = "0" + random;
                }
                //JUNTA HORA + MINUTO
                horario.setText("Horario: " + hora + ":" + min);

                //Define a imagem do tipo de acordo com o que foi escolhido
                switch (random){
                    case 0:
                        imagem.setImageResource(R.drawable.medicine);
                        break;
                    case 1:
                        imagem.setImageResource(R.drawable.pill);
                        break;
                    case 2:
                        imagem.setImageResource(R.drawable.vaccine);
                        break;
                    case 3:
                        imagem.setImageResource(R.drawable.antidote);
                        break;
                    case 4:
                        imagem.setImageResource(R.drawable.outro);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //BOTAO EXCLUIR E VOLTAR
        Button botaoExcluir = findViewById(R.id.button_excluir_remedio);
        Button botaoCancelar = findViewById(R.id.button_cancelar_excluir);

        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "REMÉDIO EXCLUIDO!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}