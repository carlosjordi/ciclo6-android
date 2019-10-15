package jordi.pe.s02_gridviewimagenes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jordi.pe.s02_gridviewimagenes.R;
import jordi.pe.s02_gridviewimagenes.model.Pais;
import jordi.pe.s02_gridviewimagenes.viewholder.GridViewholder;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<Pais> paises;

    public GridAdapter(Context context, List<Pais> paises) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int position) {
        return paises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridViewholder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.template, null);
            holder = new GridViewholder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (GridViewholder) convertView.getTag();
        }

        Pais pais = paises.get(position);
        holder.nombre.setText(pais.getNombre());
        holder.imagen.setImageResource(pais.getImagen());

        return convertView;
    }

}
