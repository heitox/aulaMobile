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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbarTop); //pegamos o material xml e linkamos ao java
        setSupportActionBar(toolbar); // esse toolbar vai ser usado para navegar entre as telas

        Button btnAcessarConf = findViewById(R.id.btnAcessaConf);
        btnAcessarConf.setOnClickListener(v -> {
           Intent intent = new Intent (MainActivity.this, ConfiguracoesActivity.class);
           startActivity(intent);
        });

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
        Intent intent = new Intent (MainActivity.this,
                ConfiguracoesActivity.class);
        startActivity(intent);
        return true;
    }

    if(item.getItemId() == R.id.menu_sobre){
        Intent intent = new Intent(MainActivity.this, SobreActivity.class);
        startActivity(intent);
        return true;
    }
        if(item.getItemId() == R.id.menu_cadastro){
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item); //
    }

}