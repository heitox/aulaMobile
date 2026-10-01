package com.example.chamadotecnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbarTop); //pegamos o material xml e linkamos ao java
        setSupportActionBar(toolbar); // esse toolbar vai ser usado para navegar entre as telas

        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> { //quando o elemento btnEnviar for clicado:
            Toast.makeText(SobreActivity.this, //vai aparecer após apertar o botão se der certo
                            "Contato registrado em nosso banco",
                            Toast.LENGTH_SHORT)
                    .show();
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); //fecha a activity que estavamos e volta para mim
        return true;
    }

    //definindo as opções do menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if (item.getItemId() == R.id.menu_config){
            Toast.makeText(SobreActivity.this, "Configurações Selecionadas",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        if(item.getItemId() == R.id.menu_cadastro){
            Intent intent = new Intent(SobreActivity.this, CadastroActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item); //
    }

}