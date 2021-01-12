package com.example.t3_activitat1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class GameAdapter extends ArrayAdapter<Games> {

    private Context context;
    private List<Games> games;


    public GameAdapter(@NonNull Context context, int resource, @NonNull List<Games> objects) {
        super(context, resource, objects);
        this.context = context;
        this.games = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Games game = games.get(position);
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_games, null);

        ImageView img = (ImageView) view.findViewById(R.id.img);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView desc = (TextView) view.findViewById(R.id.desc);
        TextView type = (TextView) view.findViewById(R.id.type);

        name.setText(game.getName());
        desc.setText(game.getDesc());
        type.setText(game.getType());

        int imgID = context.getResources().getIdentifier(game.getImg(), "drawable", context.getPackageName());
        img.setImageResource(imgID);

        return view;
    }
}

























