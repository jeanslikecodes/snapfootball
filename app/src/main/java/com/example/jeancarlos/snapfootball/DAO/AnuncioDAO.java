package com.example.jeancarlos.snapfootball.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jeancarlos.snapfootball.Database.DatabaseFactory;
import com.example.jeancarlos.snapfootball.Model.Anuncio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean Carlos on 26/05/2017.
 */

public class AnuncioDAO extends DatabaseFactory {

    public AnuncioDAO(Context context) {
        super(context);
    }

    @NonNull
    private ContentValues getContentValues(Anuncio anuncio) {
        ContentValues dados = new ContentValues();
        dados.put(DESCRICAO, anuncio.getDescricao());
        dados.put(CATEGORIA, anuncio.getCategoria());
        dados.put(MARCA, anuncio.getMarca());
        dados.put(ESTADO, anuncio.getEstado());
        dados.put(PRECO, anuncio.getPreco());
        dados.put(USU_ID, anuncio.getUsuario_id());
        return dados;
    }

    public void insertAnuncio(Anuncio anuncio) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(anuncio);
        db.insert(ANUNCIO_TABLE, null, dados);
    }

    public void updateAnuncio(Anuncio anuncio) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(anuncio);
        String[] params ={anuncio.getId_anuncio().toString()};
        db.update(ANUNCIO_TABLE, dados, ID_ANUNCIO + " = ?", params);
    }

    public void deleteAnuncio(Anuncio anuncio) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {anuncio.getId_anuncio().toString()};
        db.delete(ANUNCIO_TABLE, ID_ANUNCIO +" = ?", params);
    }

    public List<Anuncio> searchAnuncio()  {
        String sql = "SELECT * FROM "+ ANUNCIO_TABLE +";";
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery(sql, null);
            Log.d("DEBUG: ", c.toString());
            List<Anuncio> anuncios = new ArrayList<>();
            while (c.moveToNext()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setId_anuncio(c.getLong(c.getColumnIndex(ID_ANUNCIO)));
                anuncio.setDescricao(c.getString(c.getColumnIndex(DESCRICAO)));
                anuncio.setCategoria(c.getString(c.getColumnIndex(CATEGORIA)));
                anuncio.setMarca(c.getString(c.getColumnIndex(MARCA)));
                anuncio.setEstado(c.getString(c.getColumnIndex(ESTADO)));
                anuncio.setPreco(c.getDouble(c.getColumnIndex(PRECO)));
                anuncio.setUsuario_id(c.getLong(c.getColumnIndex(USU_ID)));
                anuncios.add(anuncio);
            }
            c.close();
            return anuncios;
        }
        catch (Exception e){
            Log.e("ERROR: ", e.getMessage());
            return null;
        }

    }
}
