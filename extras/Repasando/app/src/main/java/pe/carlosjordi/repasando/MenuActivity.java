package pe.carlosjordi.repasando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.carlosjordi.repasando.fragmentos.PerritoFragment;
import pe.carlosjordi.repasando.fragmentos.PollitoFragment;

public class MenuActivity extends AppCompatActivity {

    private Button volver, cambiar;
    private int fragmento_seleccionado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        inicializarElementos();
        incrustarFragmentoAnimal(new PollitoFragment());
        asignarEventoClickAlBotonVolver();
        asignarEventoClickAlBotonCambiarAnimal();
    }

    private void inicializarElementos() {
        volver = findViewById(R.id.btnVolver);
        cambiar = findViewById(R.id.btnCambiar);
    }

    private void asignarEventoClickAlBotonVolver() {
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void asignarEventoClickAlBotonCambiarAnimal() {
        cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (fragmento_seleccionado) {
                    case 0:
                        incrustarFragmentoAnimal(new PerritoFragment());
                        fragmento_seleccionado = 1;
                        break;
                    case 1:
                        incrustarFragmentoAnimal(new PollitoFragment());
                        fragmento_seleccionado = 0;
                        break;
                }
            }
        });
    }

    private void incrustarFragmentoAnimal(Fragment animal) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, animal)
                .commit();
    }
}
