package com.example.jose_jesus_guzman.agendame.Activities.Views.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Curso;
import com.example.jose_jesus_guzman.agendame.Activities.Views.ClasesViews.DetalleActivity;
import com.example.jose_jesus_guzman.agendame.R;

import java.util.List;

/**
 * Created by jesus on 4/09/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    //Esta clase pone todos los elementos de la List en cada item del recyclerView

    private List<Curso> curso;
    private Context context;

    public RecyclerAdapter(List<Curso> curso, Context context) {
        this.curso = curso;
        this.context = context; //Con este se pueden usar metodos como startActivity en clases no Activities
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycler, null); //Inflar el layout
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override //Simula un onCreate de Activity pero a nivel elemento de RecyclerView
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, final int position) {
        holder.imageView.setImageResource(curso.get(position).getImg());
        holder.textViewTitulo.setText(curso.get(position).getNombre());
        holder.textViewFecha.setText(curso.get(position).getFecha());
        holder.btnEstado.setText(curso.get(position).getEstado());
        holder.btnVerMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleActivity.class);
                //Se mandan el idImagen y el ID curso para poder llenar la vista detalle
                intent.putExtra("idCurso", curso.get(position).getId());
                intent.putExtra("idImagen", curso.get(position).getImg());
                context.startActivity(intent);
            }
        });
        holder.btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El boton ya sea que diba ver más o proximamente llevara a la pagina we.
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://it-okcenter.com/calendario/"));
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return curso.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitulo;
        TextView textViewFecha;
        Button btnEstado;
        Button btnVerMas;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            //Se iusea itemView. porque es la vista de cada uno de los elementos del recycler
            imageView = (ImageView) itemView.findViewById(R.id.card_img);
            textViewTitulo = (TextView) itemView.findViewById(R.id.card_txt_titulo);
            textViewFecha = (TextView) itemView.findViewById(R.id.card_txt_fecha);
            btnEstado = (Button) itemView.findViewById(R.id.card_btn_estado);
            btnVerMas = (Button) itemView.findViewById(R.id.card_btn_ver);
        }
    }

}
