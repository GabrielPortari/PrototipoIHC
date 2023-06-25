package com.example.prototipoihc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prototipoihc.R;

import java.util.ArrayList;
import java.util.Random;

public class EditarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        ArrayList<String> lista_remedio = new ArrayList<>();
        lista_remedio.add("Benzetacil");
        lista_remedio.add("Dorflex");
        lista_remedio.add("Placebo");
        lista_remedio.add("Dramin");
        lista_remedio.add("Ritalina");

        ArrayList<String> tipos_remedio = new ArrayList<>();
        tipos_remedio.add("Capsula");
        tipos_remedio.add("Pilula");
        tipos_remedio.add("Injeção");
        tipos_remedio.add("Gotas");
        tipos_remedio.add("Outros");


        //CONFIGURAÇÃO DO SPINNER DE SELECÃO DE REMEDIO
        Spinner spinner_select = findViewById(R.id.spinner_edit_select);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista_remedio);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select.setAdapter(arrayAdapter);
        //FIM CONFIGURAÇÃO SPINNER

        //CONFIGURAÇÃO DO SPINNER DE TIPO DE REMEDIO
        Spinner spinner_tipo = findViewById(R.id.spinner_edit_tipo);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipos_remedio);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tipo.setAdapter(arrayAdapter2);

        ImageView imagem = findViewById(R.id.image_editTipo);
        spinner_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSpinner = parent.getItemAtPosition(position).toString();
                switch (itemSpinner){
                    case "Cápsula":
                        imagem.setImageResource(R.drawable.medicine);
                        break;
                    case "Pílula":
                        imagem.setImageResource(R.drawable.pill);
                        break;
                    case "Injeção":
                        imagem.setImageResource(R.drawable.vaccine);
                        break;
                    case "Gotas":
                        imagem.setImageResource(R.drawable.antidote);
                        break;
                    case "Outro":
                        imagem.setImageResource(R.drawable.outro);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //FIM CONFIGURAÇÃO SPINNER

        EditText nome = findViewById(R.id.editText_nome_editar);
        EditText hora = findViewById(R.id.editText_hora_edit);
        EditText minuto = findViewById(R.id.editText_minuto_edit);

        spinner_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSpinner = parent.getItemAtPosition(position).toString();
                nome.setHint(itemSpinner); // mostra o nome do remedio

                //GERA UM TIPO ALEATORIO
                Random rand = new Random();
                int random = rand.nextInt(4);
                spinner_tipo.setSelection(random);

                //GERA UMA HORA ALEATORIA
                random = rand.nextInt(23);
                String horas = "" + random;
                if(random < 10) {
                    horas = "0" + random;
                }
                hora.setHint(horas);
                //GERA UM MINUTO ALEATORIO
                random = rand.nextInt(59);
                String min = "" + random;
                if(random < 10) {
                    min = "0" + random;
                }
                minuto.setHint(min);
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

        //BOTAO EDITAR E VOLTAR
        Button botaoEditar = findViewById(R.id.button_editar);
        Button botaoCancelar = findViewById(R.id.button_cancelar_editar);

        botaoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "REMÉDIO MODIFICADO!", Toast.LENGTH_SHORT).show();
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