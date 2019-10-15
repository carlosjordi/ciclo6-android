package jordi.pe.s02_gridviewimagenes.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jordi.pe.s02_gridviewimagenes.R;

public class GridViewholder {

    public TextView nombre;
    public ImageView imagen;

    public GridViewholder(View view) {
        this.nombre = view.findViewById(R.id.nombre);
        this.imagen = view.findViewById(R.id.imagen);
    }
}
