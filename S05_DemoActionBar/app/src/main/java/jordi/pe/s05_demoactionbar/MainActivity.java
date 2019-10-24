package jordi.pe.s05_demoactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarElementos();
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        establecerMenu(menu);
        SearchView buscador = obtenerBuscador(menu);
        asignarPistaAlBuscador(buscador);
        asignarEventoDeCambioDeFoco(buscador);
        asignarEventoDeTipeoTexto(buscador);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnFavorito:
                Toast.makeText(getBaseContext(), R.string.favorito_click, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnGrupo:
                Toast.makeText(getBaseContext(), R.string.grupo_click, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializarElementos() {
        toolbar = findViewById(R.id.toolbar);
    }

    private void establecerMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
    }

    private SearchView obtenerBuscador(Menu menu) {
        MenuItem item = menu.findItem(R.id.btnBuscar);
        return (SearchView) item.getActionView();
    }

    private void asignarPistaAlBuscador(SearchView buscador) {
        buscador.setQueryHint("Escribe algo...");
    }

    private void asignarEventoDeCambioDeFoco(SearchView buscador) {
        buscador.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(getBaseContext(), R.string.buscador_cambio_foco, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void asignarEventoDeTipeoTexto(SearchView buscador) {
        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getBaseContext(), R.string.buscador_texto_enviado, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getBaseContext(), R.string.buscador_cambio_texto, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
