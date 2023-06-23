package com.example.appcompra;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList listaId, listaCompra, lista, numero;

    CustomAdapter(Activity activity, Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author,
                  ArrayList book_pages){
        this.activity = activity;
        this.context = context;
        this.listaId = book_id;
        this.listaCompra = book_title;
        this.lista = book_author;
        this.numero = book_pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.lista_id_txt.setText(String.valueOf(listaId.get(position)));
        holder.listaCompra_txt.setText(String.valueOf(listaCompra.get(position)));
        holder.lista_txt.setText(String.valueOf(lista.get(position)));
        holder.numero_txt.setText(String.valueOf(numero.get(position)));



    }

    @Override
    public int getItemCount() {
        return listaId.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lista_id_txt, listaCompra_txt, lista_txt, numero_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lista_id_txt = itemView.findViewById(R.id.lista_id_txt);
            listaCompra_txt = itemView.findViewById(R.id.listaCompra_txt);
            lista_txt = itemView.findViewById(R.id.lista_txt);
            numero_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
                      Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}

