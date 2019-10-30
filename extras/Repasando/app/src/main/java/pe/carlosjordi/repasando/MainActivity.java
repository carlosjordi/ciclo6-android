package pe.carlosjordi.repasando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, contrasena;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarElementos();
        asignarEventoClickAlBotonLogin();
    }

    private void inicializarElementos() {
        usuario = findViewById(R.id.etUsuario);
        contrasena = findViewById(R.id.etContrasena);
        login = findViewById(R.id.btnLogin);
    }

    private void asignarEventoClickAlBotonLogin() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuarioContrasena();
            }
        });
    }

    private void validarUsuarioContrasena() {
        if (esUsuarioValido() && esContrasenaValida()) {
            mensajeEnTostada(":D");
            irAlMenuPrincipal();
        } else {
            mensajeEnTostada("Te equivocaste");
        }
    }

    private boolean esUsuarioValido() {
        return usuario.getText().toString().equals("Esmeralda");
    }

    private boolean esContrasenaValida() {
        return contrasena.getText().toString().equals("pollito");
    }

    private void irAlMenuPrincipal() {
        startActivity(new Intent(this, MenuActivity.class));
    }

    private void mensajeEnTostada(String mensaje) {
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
