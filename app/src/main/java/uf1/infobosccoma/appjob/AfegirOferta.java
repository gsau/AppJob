package uf1.infobosccoma.appjob;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AfegirOferta extends ActionBarActivity implements View.OnClickListener {
    public EditText titol, dataNoticia, empresa,descripcio,categoria,tipusContracte,telefon;
    public NoticiesSQLite helper;
    public ConversorNoticies conv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_oferta);
        Button bttAfegirOferta=(Button) findViewById(R.id.bttAfegirOferta);
        bttAfegirOferta.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_afegir_oferta, menu);
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

    @Override
    public void onClick(View v) {
        guardarArticle();
/*        desar();
        Toast toast = Toast.makeText(getApplicationContext(), "S'ha afegit l'oferta", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent;
        intent = new Intent(this, MainActivity_appJob.class);
        startActivity(intent);*/
    }
   private void guardarArticle(){
        titol = (EditText)findViewById(R.id.etTitolNewOfert);
        telefon = (EditText)findViewById(R.id.etTelefonNewOfert);
        categoria=(EditText)findViewById(R.id.etCategoriaNewOfert);
        tipusContracte=(EditText)findViewById(R.id.etContracteNewOfert);
        dataNoticia=(EditText)findViewById(R.id.etDataNewOfert);
        descripcio=(EditText)findViewById(R.id.etDescripcioNewOfert);
        empresa=(EditText)findViewById(R.id.etEmpresaNewOfert);
        Oferta ofert = new Oferta();
        ofert.setTitol(String.valueOf(titol.getText()));
        ofert.setCategoria(String.valueOf(categoria.getText()));
        ofert.setTelefon(String.valueOf(telefon.getText()));
        ofert.setTipusContracte(String.valueOf(tipusContracte.getText()));
        ofert.setDataNoticia(String.valueOf(dataNoticia.getText()));
        ofert.setDescripcio(String.valueOf(descripcio.getText()));
        ofert.setEmailEmpresa(String.valueOf(empresa.getText()));
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putSerializable("novaOferta",ofert);
        i.putExtras(b);
        setResult(RESULT_OK,i);
        finish();
    }
    private void desar() {
        try {
            NoticiesSQLite titHelper = new NoticiesSQLite(this, "Noticies.db", null, 2);
            ConversorNoticies titularsConv = new ConversorNoticies(titHelper);
            SQLiteDatabase db = titHelper.getWritableDatabase();
            if(db != null) {
                titularsConv.save(new Oferta(titol.getText().toString(),dataNoticia.getText().toString(),empresa.getText().toString(),descripcio.getText().toString(),categoria.getText().toString(),tipusContracte.getText().toString(),telefon.getText().toString()));
                setResult(RESULT_OK);
            }
        }
        catch(Exception e) {
            setResult(RESULT_CANCELED);
        }
        finally {
            finish();
        }
    }
}
