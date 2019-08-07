package com.example.globalcomapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalcomapp.Componentes.Cuestionario;
import com.example.globalcomapp.Componentes.Pregunta;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;


public class MyAdapterCuestionario extends ArrayAdapter<Cuestionario> {


    private static class ViewHolder {
        TextView titulo,escuela;
        TextView subtitulo;
    }

    public MyAdapterCuestionario(Context context, ArrayList<Cuestionario> cuestionarios) {
        super(context, R.layout.item_list_cuestionario, cuestionarios);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Cuestionario cuestionario = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_cuestionario, parent, false);

            viewHolder.titulo = convertView.findViewById(R.id.tituloCuestionario);
            viewHolder.subtitulo = convertView.findViewById(R.id.subtituloCuestionario);
            viewHolder.escuela = convertView.findViewById(R.id.escuela);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titulo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //TODO UPDATE the model here
                String titulo = cuestionario.getTitulo();
                String subtitulo = cuestionario.getSubTitulo();
                String json =cuestionario.getjPreguntas();

                Intent intent = new Intent(getContext(),Encuesta.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("subtitulo",subtitulo);
                intent.putExtra("json",json);

                /// do same for other values
                getContext().startActivity(intent);

            }
        });


        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.titulo.setText(cuestionario.getTitulo());
        viewHolder.subtitulo.setText(cuestionario.getSubTitulo());
        viewHolder.escuela.setText(cuestionario.getEscuela());



        // Return the completed view to render on screen
        return convertView;
    }


}
