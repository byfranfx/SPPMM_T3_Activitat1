package com.example.t3_activitat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int CODI_PETICIO = 0;
    public static final String key = "keyCountId";

    private ArrayList<Games> gameListDone = new ArrayList<>();
    private ArrayList<Games> gameListNotDone = new ArrayList<>();
    private ArrayAdapter<Games> listAdapter0;
    private ArrayAdapter<Games> listAdapter1;

    String receivedName;
    String receivedDesc;
    String receivedType;

    public int countId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recollir dades introduides del nour game.
        insertarGame(countId++);


        //
        gameListNotDone.add(new Games(countId++, "i1","Counter-Strike: GLobal Offensive","FPS, Disparos, Multijugador, Competitivo","Free To Play", false));
        gameListNotDone.add(new Games(countId++, "i2","Dota 2","FPS, Multijugador, Estrategia","Free To Play",false));
        gameListNotDone.add(new Games(countId++, "i3","Apex Legends™","FPS, Primera persona, Disparos","Free To Play",false));
        gameListNotDone.add(new Games(countId++, "i4","Deastiny 2","JcJ (PvP), JcE (PvE), Diparos","Free To Play",false));
        gameListNotDone.add(new Games(countId++, "i5","Team Fortress 2","FPS, Disparos de heroe, Multijugador","Free To Play",false));
        gameListNotDone.add(new Games(countId++, "i6","Brawlhalla","Multijugador, Lucha,  2D","Free To Play",false));

        /*new Games(1, "i1","Counter-Strike: GLobal Offensive","FPS, Disparos, Multijugador, Competitivo","Free To Play", true);
        new Games(2, "i2","Dota 2","FPS, Multijugador, Estrategia","Free To Play",false);
        new Games(3, "i3","Apex Legends™","FPS, Primera persona, Disparos","Free To Play",false);
        new Games(4, "i4","Deastiny 2","JcJ (PvP), JcE (PvE), Diparos","Free To Play",false);
        new Games(5, "i5","Team Fortress 2","FPS, Disparos de heroe, Multijugador","Free To Play",false);
        new Games(6, "i6","Brawlhalla","Multijugador, Lucha,  2D","Free To Play",false);

        Games g = new Games();

        if(g.isCheckbox()){

        }*/


        listAdapter0 = new GameAdapter(this, R.layout.list_games, gameListNotDone);
        ListView mainList = (ListView) findViewById(R.id.mainListViewNotDone);
        mainList.setAdapter(listAdapter0);

        listAdapter1 = new GameAdapter(this, R.layout.list_games, gameListDone);
        ListView mainListDone = (ListView) findViewById(R.id.mainListViewDone);
        mainListDone.setAdapter(listAdapter1);
    }

    // metode per recollir les noves dades i insertarles dins la llista
    public void insertarGame(int countId) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // llegir el contingut de extras amb la mateixa etiqueta que hem emprat per a enviar
            receivedName = extras.getString(AfegirGame.keyName);
            receivedDesc = extras.getString(AfegirGame.keyDesc);
            receivedType = extras.getString(AfegirGame.keyType);

            // modificar el TextView i escriure-ho
            //EditText textElement = findViewById(R.id.editTextAC2firstname);
            //textElement.setText(textRebut);

            gameListNotDone.add(new Games(countId++, "",receivedName,receivedDesc,receivedType, false));
            System.out.println("countId: " + countId);
        }
    }

    // checkBox
    public void checkboxUpdate(Games g){
        if(g.isCheckbox()){
            gameListDone.remove(g);
            gameListNotDone.add(g);
            Toast toast1 = Toast.makeText(getApplicationContext(), "desmarcat", Toast.LENGTH_LONG);
            toast1.show();
            g.setCheckbox(false);
        } else {
            gameListNotDone.remove(g);
            gameListDone.add(g);
            Toast toast1 = Toast.makeText(getApplicationContext(), "marcat", Toast.LENGTH_LONG);
            toast1.show();
            g.setCheckbox(true);
        }
        listAdapter0.notifyDataSetChanged();
        listAdapter1.notifyDataSetChanged();
    }

    // Action Bar
    public void actionBar(View view, int countId) {
        countId++;
        Intent i = new Intent(this, AfegirGame.class);
        i.putExtra(key,countId);
        startActivityForResult(i,CODI_PETICIO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcionMenu) {

        int id = opcionMenu.getItemId();

        if (id == R.id.AB1) {
            actionBar(null,0);
            return true;
        }
        return super.onOptionsItemSelected(opcionMenu);
    }
}