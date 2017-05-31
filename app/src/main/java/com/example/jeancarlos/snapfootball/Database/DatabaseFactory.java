package com.example.jeancarlos.snapfootball.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jean Carlos on 26/05/2017.
 */

public class DatabaseFactory extends SQLiteOpenHelper {

    private static final String Snap_DB = "snap_db";

    public static final String USUARIO_TABLE = "usuario";
    public static final String ANUNCIO_TABLE = "anuncio";

    public static final String ID_USUARIO = "id_usuario";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";

    public static final String ID_ANUNCIO = "id_anuncio";
    public static final String DESCRICAO = "descricao";
    public static final String CATEGORIA = "categoria";
    public static final String MARCA = "marca";
    public static final String ESTADO = "estado";
    public static final String PRECO = "preco";
    public static final String USU_ID = "usu_id";

    public DatabaseFactory(Context context) {
        super(context, Snap_DB, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlUsuario = "CREATE TABLE IF NOT EXISTS "+ USUARIO_TABLE +"( " +
                ID_USUARIO +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                USERNAME +" TEXT NOT NULL, " +
                EMAIL +" TEXT NOT NULL, " +
                SENHA +" TEXT NOT NULL " +
                ");";

        String sqlAnuncio = "CREATE TABLE IF NOT EXISTS "+ ANUNCIO_TABLE +"( " +
                ID_ANUNCIO +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                DESCRICAO +" TEXT NOT NULL, " +
                CATEGORIA +" TEXT NOT NULL, " +
                MARCA +" TEXT NOT NULL, " +
                ESTADO +" TEXT NOT NULL, " +
                PRECO +" TEXT NOT NULL, " +
                USU_ID +" INTEGER, " +
                "FOREIGN KEY("+ USU_ID +") REFERENCES "+ USUARIO_TABLE +"("+ ID_USUARIO +"));";

        db.execSQL(sqlUsuario);
        db.execSQL(sqlAnuncio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlUsuario = "DROP TABLE IF EXISTS "+ USUARIO_TABLE +";";
        String sqlAnuncio = "DROP TABLE IF EXISTS "+ ANUNCIO_TABLE +";";

        db.execSQL(sqlUsuario);
        db.execSQL(sqlAnuncio);
        onCreate(db);
    }
}
