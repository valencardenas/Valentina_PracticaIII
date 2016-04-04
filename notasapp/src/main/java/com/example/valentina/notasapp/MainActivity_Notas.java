package com.example.valentina.notasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_Notas extends AppCompatActivity {
    EditText eExpo,eproye, ePrac,eFinal;
    Button bCalcular,bLimpiar;
    int aux;
    double PEXPO,PPRAC,PPROY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__notas);
        eExpo=(EditText) findViewById(R.id.eExpo);
        eproye=(EditText) findViewById(R.id.eProye);
        ePrac=(EditText) findViewById(R.id.ePrac);
        eFinal=(EditText)findViewById(R.id.eFinal);
        bLimpiar=(Button) findViewById(R.id.bLimpiar);
        bCalcular=(Button) findViewById(R.id.bCalcular);
        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String limpio = "";
                eExpo.setText(String.valueOf(limpio));
                eproye.setText(String.valueOf(limpio));
                ePrac.setText(String.valueOf(limpio));
                eFinal.setText(String.valueOf(limpio));

            }

        });

bCalcular.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        double exp, prac, pro, nfinal;


        exp = Double.parseDouble((eExpo.getText().toString()));
        prac = Double.parseDouble((ePrac.getText().toString()));
        pro = Double.parseDouble((eproye.getText().toString()));
        final Bundle ext= getIntent().getExtras();/*captura los extras que mando el mainactivity*/
        if(aux==1){
            PEXPO=ext.getDouble("pExpo");
            PPROY=ext.getDouble("pProye");
            PPRAC=ext.getDouble("pPrac");
            if (exp >= 0 && exp <= 5 && prac >= 0 && prac <= 5 && pro >= 0 && pro <= 5) {

                nfinal = (PEXPO*exp +PPRAC*prac +PPROY*pro)/100;
                eFinal.setText(String.valueOf(nfinal));

            }else{
                Toast.makeText(getApplicationContext(),"Notas fuera de rango", Toast.LENGTH_SHORT).show();

            }
        }else{
            if (exp >= 0 && exp <= 5 && prac >= 0 && prac <= 5 && pro >= 0 && pro <= 5) {

                nfinal = (0.15*exp +0.50*prac +0.35*pro);
                eFinal.setText(String.valueOf(nfinal));

            }else{
                Toast.makeText(getApplicationContext(),"Notas fuera de rango", Toast.LENGTH_SHORT).show();

            }
        }




            }
        });
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.menu_config){
            aux=1;
            Toast.makeText(this, "Han presionado configurar", Toast.LENGTH_SHORT);
            Intent inte = new Intent(this,SettingsActivity.class);
            inte.putExtra("PProye",35);/*para mandar datos*/
            inte.putExtra("PExpo",15);
            inte.putExtra("PPrac",50);
            startActivityForResult(inte,1234);/*manda los datos y recibe*/
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){/*se recibe un data entonces se bajan los datos que se reciben*/
        if(requestCode==1234 && resultCode==RESULT_OK){
            String proy, exp,pra;

            proy= data.getExtras().getString("prPro");/*toca pasar esto a enteros para poder cambiarlos y calcular las notas con esos porcentajes*/
            exp= data.getExtras().getString("prExpo");
            pra= data.getExtras().getString("prPrac");

            Toast.makeText(this,"Proyecto = "+proy+" Exposicion = "+ exp +" Practicas = "+pra,Toast.LENGTH_SHORT).show();
        }
    }
}
