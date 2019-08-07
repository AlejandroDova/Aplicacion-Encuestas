package com.example.globalcomapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalcomapp.Componentes.Pregunta;

import java.util.ArrayList;

public class MyAdapterEncuesta extends ArrayAdapter<Pregunta> {



    static class ViewHolder {
        public TextView titulo;
        public RadioButton r1;
        public RadioButton r2;
        public RadioButton r3;
        public RadioButton r4;

    }

    public MyAdapterEncuesta(Context context, ArrayList<Pregunta> preguntas) {
        super(context, R.layout.item_list_encuesta, preguntas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Pregunta pregunta = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_encuesta, parent, false);

            viewHolder.titulo = convertView.findViewById(R.id.txtTituloPreguntaEncuesta);
            viewHolder.r1 = convertView.findViewById(R.id.radioButtonEncuesta);
            viewHolder.r2 = convertView.findViewById(R.id.radioButton2Encuesta);
            viewHolder.r3 = convertView.findViewById(R.id.radioButton3Encuesta);
            viewHolder.r4 = convertView.findViewById(R.id.radioButton4Encuesta);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }



//        viewHolder.r1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final MyGlobal appState = ((MyGlobal)getContext());
//                appState.getArray();
//            }
//        });
//        viewHolder.r2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(),"pos que paso banda  2",Toast.LENGTH_LONG).show();
//            }
//        });
//        viewHolder.r3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(),"pos que paso banda  3",Toast.LENGTH_LONG).show();
//            }
//        });
//        viewHolder.r4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(),"pos que paso banda  4",Toast.LENGTH_LONG).show();
//            }
//        });


        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.titulo.setText(pregunta.getTitulo());
        viewHolder.r1.setText(pregunta.getRespuesta4());
        viewHolder.r2.setText(pregunta.getRespuesta3());
        viewHolder.r3.setText(pregunta.getRespuesta2());
        viewHolder.r4.setText(pregunta.getRespuesta1());

        // Return the completed view to render on screen




        return convertView;


    }


}
