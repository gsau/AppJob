package uf1.infobosccoma.appjob;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;


public class UltimesNoticies extends ActionBarActivity {
    final static int ADD_NOTICIA = 1;
    private ListView llista;
    private Cursor noticies;
    private AdaptadorBDDNoticies adapter;
    private NoticiesSQLite titHelper;
    private ConversorNoticies noticiesConv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimes_noticies);
        llista = (ListView)findViewById(R.id.listViewNoticies);
        registerForContextMenu(llista);
        titHelper = new NoticiesSQLite(this, "Noticies.db", null, 2);
        SQLiteDatabase db = titHelper.getWritableDatabase();
        noticiesConv = new ConversorNoticies(titHelper);
        if(db != null) {
            refreshData();
            db.close();
        }
        /*llista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getBaseContext(),DetallsOferta.class);
                Bundle b=new Bundle();
                b.putSerializable("noticia", dades.get(position));
                intent.putExtras(b);
                startActivity(intent);
            }
        });*/
    }

    void refreshData() {
        noticies = noticiesConv.getAll();
        adapter = new AdaptadorBDDNoticies(this, noticies);
        llista.setAdapter(adapter);
        //noticiesConv.removeAll();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ultimes_noticies, menu);
        return true;
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if( requestCode == ADD_NOTICIA && resultCode == RESULT_OK) {
            refreshData();
        }
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
