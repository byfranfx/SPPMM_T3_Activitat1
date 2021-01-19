package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Iterator;

public class AfegirGame extends AppCompatActivity {

    private static final int PICK_IMAGE = 88;

    ImageView foto_gallery;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afegir_game);

        foto_gallery = (ImageView)findViewById(R.id.foto_gallery);

        foto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
        }
    }

    public void enviarDadesOnClick(View view) {

        // validar compos en blanco

        EditText et1 = (EditText) findViewById(R.id.nameEditText);
        String nameEditText = et1.getText().toString();

        EditText et2 = (EditText) findViewById(R.id.descEditText);
        String descEditText = et2.getText().toString();

        EditText et3 = (EditText) findViewById(R.id.typeEditText);
        String typeEditText = et3.getText().toString();

        ImageView iv4 = (ImageView) findViewById(R.id.foto_gallery);
        String imgView;



        if (nameEditText.matches("") || descEditText.matches("") || typeEditText.matches("")){

            String msg = "You did not enter a game";
            if (nameEditText.matches("") || nameEditText.isEmpty() || nameEditText == null){
                msg += " name,";
            }
            if (descEditText.matches("") || descEditText.isEmpty() || descEditText == null) {
                msg += " description,";
            }
            if (typeEditText.matches("") || typeEditText.isEmpty() || typeEditText == null) {
                msg += " type,";
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return;


        } else {

            int lengthList =  MainActivity.gameListNotDone.size();
            System.out.println("El número de elementos es de " + lengthList);

            lengthList++;
            MainActivity.gameListNotDone.add(new Games(lengthList, imageUri.toString(), nameEditText, descEditText, typeEditText, false));
            System.out.println("imatge " + imageUri.toString());
            System.out.println("El número de elementos ahora es de " + lengthList);

            Context context = getApplicationContext();
            String text = MainActivity.gameListNotDone.get(lengthList).getName();
            //System.out.println (car.get(i).getPrice());
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();

            clearOnClick(view);
        }
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