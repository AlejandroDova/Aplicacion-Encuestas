package com.example.globalcomapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.globalcomapp.Componentes.Pregunta;

import java.util.ArrayList;

public class MyAdapterPreguntas extends RecyclerView.Adapter<MyAdapterPreguntas.ViewHolderPreguntas> {
    ArrayList<Pregunta> listPregunta;

    public MyAdapterPreguntas(ArrayList<Pregunta> listPregunta) {
        this.listPregunta = listPregunta;
    }

    @NonNull
    @Override
    public ViewHolderPreguntas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_preguntas,null,false);
        return new ViewHolderPreguntas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreguntas holder, int position) {
        holder.titulo.setText(listPregunta.get(position).getTitulo());
        holder.r1.setText(listPregunta.get(position).getRespuestas().get(0).getTextRespuesta());
        holder.r2.setText(listPregunta.get(position).getRespuestas().get(1).getTextRespuesta());
        holder.r3.setText(listPregunta.get(position).getRespuestas().get(2).getTextRespuesta());
        holder.r4.setText(listPregunta.get(position).getRespuestas().get(3).getTextRespuesta());


    }

    @Override
    public int getItemCount() {
        return listPregunta.size();
    }

    public class ViewHolderPreguntas extends RecyclerView.ViewHolder {

        TextView titulo;
        RadioButton r1,r2,r3,r4;

        public ViewHolderPreguntas(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTituloPregunta);
            r1 = itemView.findViewById(R.id.radioButton);
            r2 = itemView.findViewById(R.id.radioButton2);
            r3 = itemView.findViewById(R.id.radioButton3);
            r4 = itemView.findViewById(R.id.radioButton4);

        }
    }
}
