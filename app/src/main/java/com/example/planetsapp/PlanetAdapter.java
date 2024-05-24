package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetArrayList;
    Context context;

    public PlanetAdapter(Context context, ArrayList<Planet> planetArrayList) {
        super(context, R.layout.item_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    private static class ViewHolder{
        TextView planetName, moonCount;
        ImageView planetImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planets  = getItem(position);

        ViewHolder viewHolder;
        final View result;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            viewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            viewHolder.planetImg = (ImageView) convertView.findViewById(R.id.planetImg);
            viewHolder.moonCount = (TextView) convertView.findViewById(R.id.moonCount);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.planetName.setText(planets.getPlanetName());
        viewHolder.moonCount.setText(planets.getMoonCount());
        viewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return result;
    }
}
