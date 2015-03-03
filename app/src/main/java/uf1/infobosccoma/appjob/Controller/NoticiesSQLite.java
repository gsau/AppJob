package uf1.infobosccoma.appjob.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gerard on 24/02/2015.
 */
public class NoticiesSQLite extends SQLiteOpenHelper {
    private final String SQL_CREATE_NOTICIES = "CREATE TABLE Noticies(" +
            "	codi INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "  +
            "	titol TEXT, " +
            " datat TEXT,"+
            " categoria TEXT,"+
            " tipusDeContracte TEXT,"+
            " email TEXT,"+
            " telefon TEXT,"+
            " descripcio TEXT)";
    public NoticiesSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NOTICIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Noticies");
        db.execSQL(SQL_CREATE_NOTICIES);
    }
}
