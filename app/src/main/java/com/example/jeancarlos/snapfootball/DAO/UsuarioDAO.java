package com.example.jeancarlos.snapfootball.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jeancarlos.snapfootball.Database.DatabaseFactory;
import com.example.jeancarlos.snapfootball.Model.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean Carlos on 26/05/2017.
 */

public class UsuarioDAO extends DatabaseFactory {

    public UsuarioDAO(Context context) { super(context); }

    DatabaseReference rootRef, demoRef;

    @NonNull
    private ContentValues getContentValues(Usuario usuario) {
        ContentValues dados = new ContentValues();
        dados.put(USERNAME, usuario.getUsername());
        dados.put(EMAIL, usuario.getEmail());
        dados.put(SENHA, usuario.getSenha());
        return dados;
    }

    public void insertUsuario(Usuario usuario) {


        rootRef = FirebaseDatabase.getInstance().getReference();

        demoRef = rootRef.child("users");


        Usuario user = new Usuario();

        user.setUsername("jeanslikehouses");
        user.setSenha("1234");
        user.setEmail("uehueh");




        demoRef.push().setValue(user);
    }

    public void updateUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(usuario);
        String[] params ={usuario.getId_usuario().toString()};
        db.update(USUARIO_TABLE, dados, ID_USUARIO + " = ?", params);
    }

    public void deleteUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {usuario.getId_usuario().toString()};
        db.delete(USUARIO_TABLE, ID_USUARIO +" = ?", params);
    }

    public List<Usuario> searchAnuncio()  {
        String sql = "SELECT * FROM "+ USUARIO_TABLE +";";
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery(sql, null);
            Log.d("DEBUG: ", c.toString());
            List<Usuario> usuarios = new ArrayList<>();
            while (c.moveToNext()) {
                Usuario usuario = new Usuario();
                //usuario.setId_usuario(c.getLong(c.getColumnIndex(ID_USUARIO)));
                usuario.setUsername(c.getString(c.getColumnIndex(USERNAME)));
                usuario.setEmail(c.getString(c.getColumnIndex(EMAIL)));
                usuario.setSenha(c.getString(c.getColumnIndex(SENHA)));
                usuarios.add(usuario);
            }
            c.close();
            return usuarios;
        }
        catch (Exception e){
            Log.e("ERROR: ", e.getMessage());
            return null;
        }

    }
}
