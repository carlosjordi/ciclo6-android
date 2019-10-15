package jordi.pe.s03_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jordi.pe.s03_fragments.interfaces.NombreListener;

public class MainActivity extends AppCompatActivity implements NombreListener {

    private TextView nombre;
    private Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarElementos();

        agregar.setOnClickListener(agregarFragmento);
    }

    private void inicializarElementos(){
        nombre = findViewById(R.id.tvNombre);
        agregar = findViewById(R.id.btnAgregarFragmento);
    }

    private View.OnClickListener agregarFragmento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment addFragment = new AddFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, addFragment)
                    .addToBackStack(null)
                    .commit();
        }
    };

    @Override
    public void mostrarNombre(String nombre) {
        this.nombre.setText(nombre);
    }
}
