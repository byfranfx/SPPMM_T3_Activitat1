package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Games> gameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameList.add(new Games(1, "i1","Counter-Strike: GLobal Offensive","FPS, Disparos, Multijugador, Competitivo","Free To Play"));
        gameList.add(new Games(2, "i2","Dota 2","FPS, Multijugador, Estrategia","Free To Play"));
        gameList.add(new Games(3, "i3","Apex Legends™","FPS, Primera persona, Disparos","Free To Play"));
        gameList.add(new Games(4, "i4","Deastiny 2","JcJ (PvP), JcE (PvE), Diparos","Free To Play"));
        gameList.add(new Games(5, "i5","Team Fortress 2","FPS, Disparos de heroe, Multijugador","Free To Play"));
        gameList.add(new Games(6, "i6","Brawlhalla","Multijugador, Lucha,  2D","Free To Play"));
        gameList.add(new Games(7, "i7","War Thunder","2da Guerra Mundial, Simulador","Free To Play"));

        GameAdapter list = new GameAdapter(this, R.layout.list_games, gameList);
        ListView mainList = findViewById(R.id.mainListView);
        mainList.setAdapter(list);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(view.getContext(), DetallGame.class);
                in.putExtra("mylist", gameList.get(position));
                startActivity(in);
            }
        });
    }
}