package com.example.prototipoihc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prototipoihc.R;

public class AdicionarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);
        EditText editNome = findViewById(R.id.editText_nome_adicionar);
        EditText editHora = findViewById(R.id.editText_hora_add);
        EditText editMinuto = findViewById(R.id.editText_minuto_add);
        Button botaoAdicionar = findViewById(R.id.button_adicionar);
        Button botaoCancelar = findViewById(R.id.button_cancelar_adicionar);

        //DEFINIÇÃO DO SPINNER + IMAGENS
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ImageView imageRemedio = findViewById(R.id.image_adicionarTipo);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSpinner = parent.getItemAtPosition(position).toString();
                switch (itemSpinner){
                    case "Cápsula":
                        imageRemedio.setImageResource(R.drawable.medicine);
                        break;
                    case "Pílula":
                        imageRemedio.setImageResource(R.drawable.pill);
                        break;
                    case "Injeção":
                        imageRemedio.setImageResource(R.drawable.vaccine);
                        break;
                    case "Gotas":
                        imageRemedio.setImageResource(R.drawable.antidote);
                        break;
                    case "Outro":
                        imageRemedio.setImageResource(R.drawable.outro);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //FIM DEFINICÃO DO SPINNER

        //DEFINIR EDITTEXT HORAS PARA ACEITAR 0-23 E MINUTOS 0-59
        editHora.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()){
                    int valor = Integer.parseInt(s.toString());

                    if (valor < 0 || valor > 23){
                        editHora.setError("Favor, utilizar valores de 0 - 23");
                        editHora.setText("");
                    }else{
                        editHora.setError(null);
                    }
                }
            }
        });
        editMinuto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()){
                    int valor = Integer.parseInt(s.toString());

                    if (valor < 0 || valor > 59){
                        editMinuto.setError("Favor, utilizar valores de 0 - 59");
                        editMinuto.setText("");
                    }else{
                        editMinuto.setError(null);
                    }
                }
            }
        });

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "REMÉDIO ADICIONADO!", Toast.LENGTH_SHORT).show();
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