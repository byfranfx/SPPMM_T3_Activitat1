package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Games> gameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameList.add(new Games(1, "i1","Counter-Strike: GLobal Offensive","FPS, Disparos, Multijugador, Cmpetitivo","Free To Play"));
        gameList.add(new Games(2, "i2","Dota 2","FPS, Multijugador, Estrategia","Free To Play"));



    }
}