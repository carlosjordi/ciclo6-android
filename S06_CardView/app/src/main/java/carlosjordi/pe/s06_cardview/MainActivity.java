package carlosjordi.pe.s06_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import carlosjordi.pe.s06_cardview.adapter.PaisAdapter;
import carlosjordi.pe.s06_cardview.model.Pais;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPaises;
    private List<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPaises = findViewById(R.id.rvPaises);

        establecerLayout();
        cargarData();
        setAdapter();
    }

    private void establecerLayout(){
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rvPaises.setLayoutManager(lm);
        rvPaises.setHasFixedSize(true);
    }

    private void cargarData(){
        paises = new ArrayList<>();
        paises.add(new Pais("Peru", "Tierra de palomas", R.drawable.peru));
        paises.add(new Pais("Argentina", "Los parrilleros", R.drawable.argentina));
        paises.add(new Pais("Bolivia", "Surferos", R.drawable.bolivia));
        paises.add(new Pais("Chile", "Claro po ql", R.drawable.chile));
        paises.add(new Pais("Brasil", "Eu macaco", R.drawable.brasil));
        paises.add(new Pais("Colombia", "Este es ecuador ?", R.drawable.colombia));
        paises.add(new Pais("Ecuador", "O este es ecuador ?", R.drawable.ecuador));
        paises.add(new Pais("Uruguay", "Los casi argentinos", R.drawable.uruguay));
        paises.add(new Pais("Venezuela", "Venecas :3", R.drawable.venezuela));
    }

    private void setAdapter(){
        rvPaises.setAdapter(new PaisAdapter(paises));
    }
}
