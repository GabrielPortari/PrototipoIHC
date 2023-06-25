package com.example.prototipoihc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototipoihc.R;
import com.example.prototipoihc.objects.Remedio;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListaRemedioViewHolder> {

    private List<Remedio> remedios;

    public Adapter(List<Remedio> remedios) {
        this.remedios = remedios;
    }

    @NonNull
    @Override
    public ListaRemedioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_remedio, parent, false);
        return new ListaRemedioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaRemedioViewHolder holder, int position) {
        holder.nomeRemedio.setText(remedios.get(position).getNome());
        holder.tipoRemedio.setText(remedios.get(position).getTipo());
        String hora, minuto, horario;

        if(remedios.get(position).getHora() < 10){
            hora = "0" + remedios.get(position).getHora();
        }else{
            hora = String.valueOf(remedios.get(position).getHora());
        }
        if(remedios.get(position).getMin() < 10){
            minuto = "0" + remedios.get(position).getMin();
        }else{
            minuto = String.valueOf(remedios.get(position).getMin());
        }

        horario = hora + ":" + minuto;
        holder.horarioRemedio.setText(horario);
    }

    @Override
    public int getItemCount() {
        return (remedios != null && remedios.size() > 0) ? remedios.size() : 0;
    }

    static class ListaRemedioViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeRemedio;
        private TextView tipoRemedio;
        private TextView horarioRemedio;

        public ListaRemedioViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeRemedio = itemView.findViewById(R.id.text_nome_itemlista);
            tipoRemedio = itemView.findViewById(R.id.text_tipo_itemlista);
            horarioRemedio = itemView.findViewById(R.id.text_horario_itemlista);
        }
    }

}
