package com.example.tp4_moviles.ui.farmacias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4_moviles.R;
import com.example.tp4_moviles.models.Farmacia;

import java.util.ArrayList;

public class FarmaciasAdapter extends RecyclerView.Adapter<FarmaciasAdapter.ViewHolderFarmacia> {

    private ArrayList<Farmacia> farmacias;
    private LayoutInflater li;

    public FarmaciasAdapter(ArrayList<Farmacia> farmacias, LayoutInflater li) {
        this.farmacias = farmacias;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderFarmacia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item, parent, false);
        return new ViewHolderFarmacia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFarmacia holder, int position) {
        Farmacia farmacia = farmacias.get(position);
        holder.ivFoto.setImageResource(farmacia.getFoto());
        holder.tvNombre.setText(farmacia.getNombre());
        holder.tvDireccion.setText(farmacia.getDireccion());
        holder.tvHorario.setText(farmacia.getHorario());

    }

    @Override
    public int getItemCount() {
        return farmacias.size();
    }

    public static class ViewHolderFarmacia extends RecyclerView.ViewHolder {

        TextView tvNombre, tvDireccion, tvHorario;
        ImageView ivFoto;

        public ViewHolderFarmacia(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvHorario = itemView.findViewById(R.id.tvHorario);
            ivFoto = itemView.findViewById(R.id.ivFoto);

        }
    }

}
