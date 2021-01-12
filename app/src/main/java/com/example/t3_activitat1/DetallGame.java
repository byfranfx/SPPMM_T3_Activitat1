package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DetallGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detall_game);

        Intent i = getIntent();
        Games game = (Games) i.getSerializableExtra("gamelistid");
        Toast.makeText(getApplicationContext(),"Detall game" + game ,Toast.LENGTH_SHORT).show();
    }
}