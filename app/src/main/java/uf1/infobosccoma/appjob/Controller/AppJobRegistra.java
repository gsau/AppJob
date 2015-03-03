package uf1.infobosccoma.appjob.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uf1.infobosccoma.appjob.Model.Persona;
import uf1.infobosccoma.appjob.R;


public class AppJobRegistra extends ActionBarActivity implements View.OnClickListener {
    Dades dades;
    private boolean treballador=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_job_registra);
       // demo();
        Button butNoRegistrat = (Button) findViewById(R.id.bttNoRegistrat);
        Button butEntrar=(Button) findViewById(R.id.bttEntrar);
        butEntrar.setOnClickListener(this);
        butNoRegistrat.setOnClickListener(this);
    }
    /*private void demo(){
        dades.ofertas.add(new Oferta("Mecanic de cotxes", "12/02/2015", "info@icrek.com", "Es tracte de canviar rodes basicament", "Mecanica", "indefinit","972294569"));
        dades.ofertas.add(new Oferta("Programador", "12/02/2015", "info@icrek.com", "Es necesita programador especialista amb el llenguatge java.", "Informatica", "indefinit","972294569"));
        dades.ofertas.add(new Oferta("Cambrer", "12/02/2015", "info@icrek.com", "Es necesita cambrer per a un bar. Es valorara idiomes", "Hosteleria", "indefinit","972294569"));
        dades.ofertas.add(new Oferta("Cuiner", "12/02/2015", "info@icrek.com", "Cuiner de delicateses", "Hosteleria", "indefinit","972294569"));
    }*/

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.bttNoRegistrat:
                EditText text;
                text = (EditText) findViewById(R.id.etEmailRegistra);
                text.setVisibility(arg0.VISIBLE);
                TextView email;
                email = (TextView) findViewById(R.id.textView4);
                email.setVisibility(arg0.VISIBLE);
                Button but = (Button) findViewById(R.id.bttNoRegistrat);
                but.setVisibility(arg0.INVISIBLE);
                break;
            case R.id.bttEntrar:
                afegirUser();
                break;
        }
    }

    private void afegirUser() {
        EditText nom, pass, email;
        nom = (EditText) findViewById(R.id.etNomUser);
        pass = (EditText) findViewById(R.id.etPass);
        email = (EditText) findViewById(R.id.etEmailRegistra);
        Intent intent;
        intent = new Intent(this, MainActivity_appJob.class);
        Persona prs=new Persona(nom.getText().toString(), pass.getText().toString());
        if (email.isShown()) {
            dades.personas.add(prs);
            Toast toast = Toast.makeText(getApplicationContext(), "S'ha afegit l'usuari", Toast.LENGTH_SHORT);
            toast.show();
            startActivity(intent);
        } else {
            if(existeix(prs)){
                Toast toast =Toast.makeText(getApplicationContext(),"Usuari Correcte", Toast.LENGTH_SHORT);
                toast.show();
                startActivity(intent);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "Usuari Incorrecte", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private boolean existeix(Persona pers) {
        Persona persons;
        for(int i=0;i<dades.personas.size();i++){
            persons=dades.personas.get(i);
            if(pers.compareTo(persons)==0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_job_registra, menu);
        return true;
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
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
