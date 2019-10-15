package jordi.pe.s03_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import jordi.pe.s03_fragments.interfaces.NombreListener;

public class AddFragment extends Fragment {

    private Button mostrar;
    private EditText nombre;
    private NombreListener listener;

    public AddFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);

        inicializarElementos(view);
        mostrar.setOnClickListener(mostrarNombre);

        return view;
    }

    private void inicializarElementos(View view){
        mostrar = view.findViewById(R.id.btnMostrar);
        nombre = view.findViewById(R.id.etNombre);
    }

    private View.OnClickListener mostrarNombre = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.mostrarNombre(nombre.getText().toString());
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (NombreListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + ". Debes implementar la interfaz");
        }
    }
}
