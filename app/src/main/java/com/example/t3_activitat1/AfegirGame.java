package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;

public class AfegirGame extends AppCompatActivity {

    private static final int CODI_PETICIO = 0;

    public static final String keyName = "keyName";
    public static final String keyDesc = "keyDesc";
    public static final String keyType = "keyType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afegir_game);
    }


    /*@Override
    public void finish() {

        EditText text = findViewById(R.id.nameEditText);
        String valor = text.getText().toString();
        Intent data = new Intent();
        data.putExtra(keyName, valor);
        setResult(RESULT_OK, data);

        EditText desc = findViewById(R.id.descEditText);
        valor = desc.getText().toString();
        data = new Intent();
        data.putExtra(keyDesc, valor);
        setResult(RESULT_OK, data);

        EditText type = findViewById(R.id.typeEditText);
        valor = type.getText().toString();
        data = new Intent();
        data.putExtra(keyType, valor);
        setResult(RESULT_OK, data);
        super.finish();
    }

    public void tancaActivitat(View view) {
        finish();
    }*/

    public void enviarDadesOnClick(View view) {

        EditText et1 = (EditText) findViewById(R.id.nameEditText);
        String nameEditText = et1.getText().toString();

        EditText et2 = (EditText) findViewById(R.id.descEditText);
        String descEditText = et2.getText().toString();

        EditText et3 = (EditText) findViewById(R.id.typeEditText);
        String typeEditText = et3.getText().toString();

        int lengthList =  MainActivity.gameListNotDone.size();
        System.out.println("El número de elementos es de ");

        lengthList++;
        MainActivity.gameListNotDone.add(new Games(lengthList, "",nameEditText,descEditText,typeEditText, false));
        System.out.println(lengthList);

        /*Iterator it =  MainActivity.gameListNotDone.iterator();
        while(it.hasNext())
            System.out.println(it.next());*/

        Context context = getApplicationContext();
        String text = Integer.toString(lengthList);
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();



        //agafar el text introduït
        /*EditText et1 = (EditText) findViewById(R.id.nameEditText);
        String nameEditText = et1.getText().toString();

        EditText et2 = (EditText) findViewById(R.id.descEditText);
        String descEditText = et2.getText().toString();

        EditText et3 = (EditText) findViewById(R.id.typeEditText);
        String typeEditText = et3.getText().toString();

        //Accions a fer...
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(keyName,nameEditText);
        i.putExtra(keyDesc,descEditText);
        i.putExtra(keyType,typeEditText);
        startActivityForResult(i,CODI_PETICIO);*/
    }

    public void cancelOnClick(View view)
    {
        finish();
    }

    public void clearOnClick(View view)
    {
        EditText ft = findViewById(R.id.nameEditText);
        ft.setText("");

        ft = findViewById(R.id.descEditText);
        ft.setText("");

        ft = findViewById(R.id.typeEditText);
        ft.setText("");
    }
}