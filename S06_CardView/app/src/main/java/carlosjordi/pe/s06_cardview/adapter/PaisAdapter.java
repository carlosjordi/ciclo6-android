package carlosjordi.pe.s06_cardview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import carlosjordi.pe.s06_cardview.R;
import carlosjordi.pe.s06_cardview.model.Pais;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder> {

    private List<Pais> paises;

    public PaisAdapter(List<Pais> paises) {
        this.paises = paises;
    }

    @NonNull
    @Override
    public PaisViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_cardview, viewGroup, false);
        return new PaisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaisViewHolder pvh, int posicion) {
        pvh.pais.setText(paises.get(posicion).getNombre());
        pvh.descripcion.setText(paises.get(posicion).getDescripcion());
        pvh.bandera.setImageResource(paises.get(posicion).getBandera());
    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    static class PaisViewHolder extends RecyclerView.ViewHolder{

        TextView pais, descripcion;
        ImageView bandera;

        public PaisViewHolder(@NonNull View itemView) {
            super(itemView);
            pais = itemView.findViewById(R.id.tvPais);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            bandera = itemView.findViewById(R.id.ivBandera);
        }
    }
}
