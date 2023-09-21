package com.example.farmacialp.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmacialp.R;

import java.util.List;

public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.ViewHolder>{

    private  List<Farmacia> farmacias;
    private Context context;

    private LayoutInflater li;


    public FarmaciaAdapter(List<Farmacia> farmacias, Context context, LayoutInflater li) {
        this.farmacias = farmacias;
        this.context = context;
        this.li = li;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item_farmacia, parent, false);


        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("salida", "mostrando");
        String n= farmacias.get(position).getNombre();
        String d= farmacias.get(position).getDireccion();
        holder.tvnomfar.setText(n);
        holder.tvdirfar.setText(d);


    }

    @Override
    public int getItemCount() {

        return farmacias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvnomfar;
        private TextView tvdirfar;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnomfar=itemView.findViewById(R.id.tvnomfar);
            tvdirfar=itemView.findViewById(R.id.tvdirfar);

            //itemView.setOnClickListener();




        }
    }
}

