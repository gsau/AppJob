package uf1.infobosccoma.appjob;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetallsOferta extends ActionBarActivity implements View.OnClickListener {
    Oferta ofert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalls_oferta);
        Bundle bundle=getIntent().getExtras();
        ofert=(Oferta) getIntent().getExtras().getSerializable("noticia");
        TextView titol=(TextView)findViewById(R.id.txtTitolDetall);
        TextView categoria=(TextView)findViewById(R.id.txtCategoriaDetall);
        TextView emailEmpresa=(TextView)findViewById(R.id.txtEmailEmpresaDetall);
        TextView dataNoticia=(TextView)findViewById(R.id.txtDataDetall);
        TextView contracte=(TextView)findViewById(R.id.txtContracteDetall);
        TextView descripcio=(TextView)findViewById(R.id.txtDescricioDetall);
        titol.setText(ofert.getTitol());
        categoria.setText(ofert.getCategoria());
        emailEmpresa.setText(ofert.getEmailEmpresa());
        dataNoticia.setText(ofert.getDataNoticia());
        contracte.setText(ofert.getTipusContracte());
        descripcio.setText(ofert.getDescripcio());
        Button but=(Button)findViewById(R.id.bttTrucarTelf);
        but.setOnClickListener(this);
        Button but1=(Button)findViewById(R.id.bttEnviarEmail);
        but1.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalls_oferta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void metodeAjuda(){
        Toast toast = Toast.makeText(getApplicationContext(), "Aquesta finestra consta de tres botons: 1-cercar ofertes de feina:et porta a un llistat d'ofertes", Toast.LENGTH_LONG);
        toast.show();
        Toast toast1 = Toast.makeText(getApplicationContext(), "2-Afegir Ofertes de feina: et porta a una nova finestra on emplenarem les dades de l'oferta ", Toast.LENGTH_LONG);
        toast1.show();
        Toast toast2 = Toast.makeText(getApplicationContext(), "3-+info de l'APP et mostra informació relativa a l'app ", Toast.LENGTH_LONG);
        toast2.show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bttEnviarEmail:
                Intent intents;
                intents = new Intent(this, EnviamentCorreu.class);
                startActivity(intents);
                break;
            case R.id.bttTrucarTelf:
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ofert.getTelefon().toString()));
                startActivity(intent);
                break;
        }
    }
}
