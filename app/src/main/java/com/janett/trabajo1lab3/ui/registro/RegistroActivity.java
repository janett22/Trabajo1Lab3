package com.janett.trabajo1lab3.ui.registro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.janett.trabajo1lab3.R;
import com.janett.trabajo1lab3.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private EditText dni, apellido, mail, nombre, contra;
    private Button guardar;
    private RegistroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        vm = new ViewModelProvider(this).get(RegistroActivityViewModel.class);
        iniciar();
        vm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                dni.setText(String.valueOf(usuario.getDni()));
                apellido.setText(usuario.getApellido());
                mail.setText(usuario.getEmail());
                nombre.setText(usuario.getNombre());
                contra.setText(usuario.getPassword());
            }
        });
        vm.cargarDatos(getIntent().getBooleanExtra("login",false));
    }

    public  void iniciar() {
        dni = findViewById(R.id.etDni);
        apellido = findViewById(R.id.etApellido);
        nombre = findViewById(R.id.etNombre);
        mail = findViewById(R.id.etEmail);
        contra = findViewById(R.id.etPassword);
        guardar = findViewById(R.id.btGuardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.guardarDatos(Long.parseLong(dni.getText().toString()),nombre.getText().toString(),apellido.getText()
                        .toString(),mail.getText().toString(),contra.getText().toString());
            }
        });
    }

}