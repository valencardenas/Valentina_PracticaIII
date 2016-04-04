package com.example.valentina.notasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    EditText epExp, epPra,epPro;
    Button bSave, bClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        epExp=(EditText) findViewById(R.id.ePExpo);
        epPra=(EditText) findViewById(R.id.ePPrac);
        epPro=(EditText) findViewById(R.id.ePProye);
        bSave=(Button) findViewById(R.id.bSave);
        bClean=(Button) findViewById(R.id.bClean);


        final Bundle extras= getIntent().getExtras();/*captura los extras que mando el mainactivity*/
        epExp.setText(String.valueOf(extras.getInt("PExpo")));
        epPra.setText(String.valueOf(extras.getInt("PPrac")));
        epPro.setText(String.valueOf(extras.getInt("PProye")));


        bClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String limpio = "";
                epExp.setText(String.valueOf(limpio));
                epPro.setText(String.valueOf(limpio));
                epPra.setText(String.valueOf(limpio));

            }

        });


           bSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double pexpo , pprac , pproye, porc;

                pexpo=Double.parseDouble((epExp.getText().toString()));
                pprac=Double.parseDouble((epExp.getText().toString()));
                pproye=Double.parseDouble((epExp.getText().toString()));

                porc=pexpo + pprac + pproye;
                if(porc == 100){
                    Toast.makeText(SettingsActivity.this, "Se han guardado los cambios", Toast.LENGTH_SHORT);
                    Intent inten = new Intent(SettingsActivity.this,MainActivity_Notas.class);
                    inten.putExtra("pProye",pproye);/*para mandar datos*/
                    inten.putExtra("pExpo",pexpo);
                    inten.putExtra("pPrac", pprac);
                    startActivityForResult(inten, 1234);/*manda los datos y recibe*/
                }
                else{

                }


            }

        });


    }

}
