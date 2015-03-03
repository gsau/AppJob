package uf1.infobosccoma.appjob.Controller;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import uf1.infobosccoma.appjob.R;


public class EnviamentCorreu extends ActionBarActivity implements View.OnClickListener {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviament_correu);
        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.ic_appjob);
        Button butCancel=(Button) findViewById(R.id.bttCancelEmail);
        butCancel.setOnClickListener(this);
        Button butEnviar=(Button) findViewById(R.id.bttSendEmail);
        butEnviar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enviament_correu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bttSendEmail:
                break;
            case R.id.bttCancelEmail:
                EditText assumpte,cosMissatge;
                assumpte=(EditText)findViewById(R.id.etAsumpteEmail);
                cosMissatge=(EditText)findViewById(R.id.etCosMissatge);
                assumpte.setText("Assumpte");
                cosMissatge.setText("Cos missatge");
                break;
        }
    }
}
