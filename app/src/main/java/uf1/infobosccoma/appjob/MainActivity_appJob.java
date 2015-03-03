package uf1.infobosccoma.appjob;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity_appJob extends ActionBarActivity implements View.OnClickListener {
    ImageView image;
    int id;
    final static int ADD_NOTICIA = 1;
    private AdaptadorBDDNoticies adapter;
    private NoticiesSQLite titHelper;
    private ConversorNoticies noticiesConv;
    private Cursor noticies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_app_job);
        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.ic_esloganappjob);
        Button bttSearchOferts = (Button) findViewById(R.id.bttSearchOferts);
        Button bttCreateOfert=(Button) findViewById(R.id.bttCreateOfert);
        bttCreateOfert.setOnClickListener(this);
        bttSearchOferts.setOnClickListener(this);
        titHelper = new NoticiesSQLite(this, "Noticies.db", null, 2);
        SQLiteDatabase db = titHelper.getWritableDatabase();
        noticiesConv= new ConversorNoticies(titHelper);
     }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.bttSearchOferts:
                Intent intent;
                intent = new Intent(this, UltimesNoticies.class);
                startActivity(intent);
                break;
            case R.id.bttCreateOfert:
                Intent inte;
                inte = new Intent(this,AfegirOferta.class);
                startActivityForResult(inte, ADD_NOTICIA);
                break;
            case R.id.bttInfo:
                Intent intent1;
                intent1=new Intent(this,InfoApp.class);
                startActivity(intent1);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity_app_job, menu);
        return true;
    }
    public void metodeInfo(){
        Intent intent;
        intent = new Intent(this, AfegirOferta.class);
        startActivity(intent);
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
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()){
           case R.id.action_afegirOfert:
               metodeInfo();
               return true;
           case  R.id.action_ajuda:
               metodeAjuda();
               return true;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if( requestCode == ADD_NOTICIA && resultCode == RESULT_OK) {
            Oferta ofert;
            ofert = (Oferta) data.getExtras().getSerializable("novaOferta");
            noticiesConv.save(ofert);
            Toast toast = Toast.makeText(getApplicationContext(), "S'ha afegit l'oferta", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
