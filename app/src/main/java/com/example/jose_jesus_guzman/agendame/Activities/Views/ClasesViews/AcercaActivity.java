package com.example.jose_jesus_guzman.agendame.Activities.Views.ClasesViews;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.jose_jesus_guzman.agendame.R;

public class AcercaActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.acerca_de));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Poner boton de atras en el action bar

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Un dialogo para validar si el usuario quiere ir al link de github o no
                new AlertDialog.Builder(AcercaActivity.this)
                        .setTitle(getResources().getString(R.string.acerca_dialog_titulo))
                        .setMessage(getResources().getString(R.string.acerca_dialog_mensaje))
                        .setPositiveButton(getResources().getString(R.string.Si), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Pone la aplicacion en segundo plano y se dirije al repositorio de la app
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jose1824/Agendame.git"));
                                startActivity(browserIntent);
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.No), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Cierra el dialogo
                                dialogInterface.dismiss();
                            }
                        })
                        .show();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Ir a la activity principal
        startActivity(new Intent(AcercaActivity.this, LoginActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
