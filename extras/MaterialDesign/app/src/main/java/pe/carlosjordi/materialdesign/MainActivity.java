package pe.carlosjordi.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setFabOnClickListener();
    }

    private void setToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setFabOnClickListener(){
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Me hiciste click :3", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setMenu(menu);
        SearchView search = getSearchView(menu);
        setSearchViewHint(search);
        setOnFocusChangeListener(search);
        setOnTextChangeListener(search);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_stop:
                Toast.makeText(this, "Alto Detente!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
    }

    private SearchView getSearchView(Menu menu){
        MenuItem item = menu.findItem(R.id.icon_search);
        return (SearchView) item.getActionView();
    }

    private void setSearchViewHint(SearchView search){
        search.setQueryHint("Escribe algo...");
    }

    private void setOnFocusChangeListener(SearchView search){
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                toastMessage("Cambiando el foco");
            }
        });
    }
    private void setOnTextChangeListener(SearchView search){
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                toastMessage("Buscando...");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                toastMessage("Estás escribiendo");
                return true;
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
