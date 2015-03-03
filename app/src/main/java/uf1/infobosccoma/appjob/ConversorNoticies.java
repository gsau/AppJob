package uf1.infobosccoma.appjob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Gerard on 24/02/2015.
 */
public class ConversorNoticies {
    private NoticiesSQLite helper;
    public ConversorNoticies(){

    }
    public ConversorNoticies(NoticiesSQLite helper) {
        this.helper = helper;
    }
    public long save(Oferta oferta) {
        long index = -1;
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues dades = new ContentValues();
        dades.put("titol", oferta.getTitol());
        dades.put("data", oferta.getDataNoticia());
        dades.put("categoria", oferta.getCategoria());
        dades.put("tipusDeContracte", oferta.getTipusContracte());
        dades.put("email", oferta.getEmailEmpresa());
        dades.put("telefon",oferta.getTelefon());
        dades.put("descripcio", oferta.getDescripcio());
        try {
            index = db.insertOrThrow("Noticies", null, dades);
            Log.i("Noticies", dades.toString() + " afegit amb codi " + index);
        }
        catch(Exception e) {
            Log.e("Noticies", e.getMessage());
        }
        return index;
    }
   /* public Cursor getPosition(int pos){
        SQLiteDatabase db = helper.getReadableDatabase();

    }*/
    public Cursor getAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        return db.query(true, "Noticies",
                new String[]{"titol","data", "categoria","tipusDeContracte","email","telefon","descripcio"},
                null, null, null, null, null, null);
    }
    public boolean remove(Oferta f) {
        SQLiteDatabase db = helper.getWritableDatabase();
        return db.delete("Noticies", "codi=" +f.getCodi() ,null ) > 0;
    }

    public boolean removeAll() {
        SQLiteDatabase db = helper.getWritableDatabase();
        return db.delete("Noticies", null, null ) > 0;
    }
}
