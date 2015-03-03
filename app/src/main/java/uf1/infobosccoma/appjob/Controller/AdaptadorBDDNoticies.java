package uf1.infobosccoma.appjob.Controller;

/**
 * Created by Gerard on 26/02/2015.
 */

import android.app.Activity;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import uf1.infobosccoma.appjob.Model.Oferta;
import uf1.infobosccoma.appjob.R;

public class AdaptadorBDDNoticies extends BaseAdapter {
    private Activity context;
    private Cursor dades;

    AdaptadorBDDNoticies(Activity context, Cursor dades) {
        super();
        this.context = context;
        this.dades = dades;
    }

    /**
     * Sobreescriptura del mètode getView per indicar com s'han de mostrar
     * les dades d'una fila del ListView
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        View element = convertView;
        Oferta f = getItem(position);
        if (element == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            element = inflater.inflate(R.layout.activity_llista_noticies, null);
        }
        TextView lblVenedor = (TextView)element.findViewById(R.id.txtTitol);
       lblVenedor.setText(f.getTitol());

       TextView lblTelefon = (TextView)element.findViewById(R.id.txtCategoria);
        lblTelefon.setText(f.getCategoria());
        return element;
    }

    public int getCount() {
        return dades.getCount();
    }

    /**
     * Sobreescriptura del mètode getItem que retorna l'objecte que ocupa la
     * posició indicada amb el paràmetre.
     */
    public Oferta getItem(int pos) {
        Oferta t = new Oferta();
        if (dades.moveToPosition(pos)) {
            t.setTitol(dades.getString(0));
            t.setCategoria(dades.getString(1));
            t.setDataNoticia(dades.getString(2));
            t.setEmailEmpresa(dades.getString(3));
            t.setTelefon(dades.getString(4));
            t.setDescripcio(dades.getString(5));
            t.setTipusContracte(dades.getString(6));
        }
        return t;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getCodi();
    }

}