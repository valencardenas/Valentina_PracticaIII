package com.example.valentina.colombiaturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity_Publicidad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__publicidad);
        Button bHoteles= (Button)findViewById(R.id.bHoteles);
        Button bBares= (Button)findViewById(R.id.bBares);
        Button bSitios= (Button)findViewById(R.id.bSitios);
        Button bInfo= (Button)findViewById(R.id.bInfo);

        bHoteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity_Publicidad.this, HotelesActivity.class);
                startActivity(intent);


            }
        });

        bBares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity_Publicidad.this, BaresActivity.class);
                startActivity(intent);

            }
        });

        bSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity_Publicidad.this, SitiosActivity.class);
                startActivity(intent);


            }
        });

        bInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity_Publicidad.this, InfoActivity.class);
                startActivity(intent);

            }
        });



    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.acercade, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.menu_acerca) {
            Intent inte = new Intent(this, AcercaActivity.class);
            startActivity(inte);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
