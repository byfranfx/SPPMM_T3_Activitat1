package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AfegirGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afegir_game);
    }

    @Override
    public void finish()
    {
        EditText name = findViewById(R.id.nameEditText);
        String valor = name.getText().toString();
        Intent data = new Intent();
        data.putExtra("Nombre", valor);
        setResult(RESULT_OK, data);

        EditText desc = findViewById(R.id.descEditText);
        valor = desc.getText().toString();
        data = new Intent();
        data.putExtra("Descripcion", valor);
        setResult(RESULT_OK, data);

        EditText type = findViewById(R.id.typeEditText);
        valor = type.getText().toString();
        data = new Intent();
        data.putExtra("Type", valor);
        setResult(RESULT_OK, data);
        super.finish();
    }
    public void tancaActivitat(View view)
    {
        finish();
    }
}