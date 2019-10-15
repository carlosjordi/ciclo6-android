package jordi.pe.s03_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinPaises, spinPlanetas;
    private List<String> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarElementos();
        cargarListaPaises();
        establecerAdaptadorPaises();
        establecerAdaptadorPlanetas();

        spinPaises.setOnItemSelectedListener(paisSeleccionado);
    }

    private void inicializarElementos(){
        spinPaises = findViewById(R.id.spinner_pais);
        spinPlanetas = findViewById(R.id.spinner_planeta);
        paises = new ArrayList<>();
    }

    private void cargarListaPaises(){
        paises.add("Argentina");
        paises.add("Bolivia");
        paises.add("Colombia");
        paises.add("Perú");
        paises.add("Uruguay");
        paises.add("Chile");
        paises.add("Ecuador");
        paises.add("Venezuela");
        paises.add("Brasil");
        paises.add("Paraguay");
    }

    private void establecerAdaptadorPaises(){
        ArrayAdapter<String> adapterPais =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paises);
        adapterPais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPaises.setAdapter(adapterPais);
    }

    private void establecerAdaptadorPlanetas(){
        ArrayAdapter<CharSequence> adapterPlaneta =
                ArrayAdapter.createFromResource(
                        this, R.array.planetas, android.R.layout.simple_spinner_item);
        adapterPlaneta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPlanetas.setAdapter(adapterPlaneta);
    }

    private AdapterView.OnItemSelectedListener paisSeleccionado =
            new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(
                    MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT)
                    .show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
}
