package jordi.pe.s02_gridviewimagenes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jordi.pe.s02_gridviewimagenes.adapter.GridAdapter;
import jordi.pe.s02_gridviewimagenes.model.Pais;

public class MainActivity extends AppCompatActivity {

    private GridView grid;
    private List<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarElementos();
        cargarListaPaises();
        establecerAdaptador();

        grid.setOnItemClickListener(gridItemClicked);
    }

    private void inicializarElementos(){
        grid = findViewById(R.id.grilla);
        paises = new ArrayList<>();
    }

    private void cargarListaPaises(){
        paises.add(new Pais("Argentina", R.drawable.argentina));
        paises.add(new Pais("Bolivia", R.drawable.bolivia));
        paises.add(new Pais("Brasil", R.drawable.brasil));
        paises.add(new Pais("Chile", R.drawable.chile));
        paises.add(new Pais("Colombia", R.drawable.colombia));
        paises.add(new Pais("Ecuador", R.drawable.ecuador));
        paises.add(new Pais("Perú", R.drawable.peru));
        paises.add(new Pais("Uruguay", R.drawable.uruguay));
        paises.add(new Pais("Venezuela", R.drawable.venezuela));
    }

    private void establecerAdaptador(){
        GridAdapter adapter = new GridAdapter(this, paises);
        grid.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener gridItemClicked = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, paises.get(i).getNombre(), Toast.LENGTH_SHORT).show();
        }
    };
}
