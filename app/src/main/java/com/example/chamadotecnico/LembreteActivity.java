package com.example.chamadotecnico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class LembreteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lembrete);

        MaterialToolbar toolbar = findViewById(R.id.toolbarLembrete);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        EditText edtTitulo = findViewById(R.id.edtTituloLembrete);
        Button btnSalvar = findViewById(R.id.btnSalvarLembrete);

        btnSalvar.setOnClickListener(v -> {
            String titulo = edtTitulo.getText().toString().trim();

            if (titulo.isEmpty()) {
                Toast.makeText(this, "Informe o título do lembrete", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Lembrete registrado!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}