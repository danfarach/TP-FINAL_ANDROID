package com.example.android.trabajo4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Stock> lista;
    private TextView titulo;
    private ListView listViewStock;
    private AdapterProductos adapterStock;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<Stock>();
        Stock p1 = new Stock("Coca", 7, 10);
        lista.add(p1);

        listViewStock = findViewById(R.id.lv);
        listViewStock.setAdapter(adapterStock);

        titulo = findViewById(R.id.textView3);
        titulo.setText("Notas ORT");

        adapterStock = new AdapterProductos(this, lista);
        listViewStock.setAdapter(adapterStock);

        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);


//--------------------------------------------------------------------------------------------------------------------------
     /*

        listViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Materia analogica, sistemas;


                // lista.get(position).getNombre();
                Toast.makeText(MainActivity.this, lista.get(position).getNombre() , Toast.LENGTH_SHORT).show();
                if (lista.get(position).getNombre().equals("Analógica")){
                    analogica = new Materia(lista.get(position).getNombre(), "Descripción de analogica");
                    EventBus.getDefault().post(analogica);
                    Intent i = new Intent(getApplicationContext(), Agregar.class);
                    startActivity(i);
                }
                else if (lista.get(position).getNombre().equals("Sistemas")){
                    sistemas = new Materia(lista.get(position).getNombre(), "Descripción de sistemas");
                    EventBus.getDefault().post(sistemas);
                    Intent i = new Intent(getApplicationContext(), Agregar.class);
                    startActivity(i);
                }


            }
        });

      */
    }


    class AdapterProductos extends ArrayAdapter<Stock>
    {

        private Activity context;
        private ArrayList<Stock> listProductos;

        class ViewHolder
        {
            TextView producto;
            TextView cantidad;
            TextView precio;
        }

        AdapterProductos(Activity context, ArrayList<Stock> listProductos)
        {
            super(context, R.layout.item_producto, listProductos);
            this.context = context;
            this.listProductos = listProductos;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View item = convertView;
            ViewHolder holder;

            if(item == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.item_producto, null);

                holder = new ViewHolder();
                holder.producto = item.findViewById(R.id.Producto);
                holder.cantidad = item.findViewById(R.id.cantidad);
                holder.precio = item.findViewById(R.id.precio);
                item.setTag(holder);
                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag();
            }

            //holder.txtMateria.setText(listProductos.get(position).getNombre());

            return(item);
        }
    }



    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {



            case R.id.tTrim:

                //Toast.makeText(MainActivity.this, "Seleccione el sujeto que quiere editar", Toast.LENGTH_SHORT).show();

                Intent i = new Intent (getApplicationContext(), Agregar.class);
                startActivity(i);
                break;


        }

        return true;
    }

}
