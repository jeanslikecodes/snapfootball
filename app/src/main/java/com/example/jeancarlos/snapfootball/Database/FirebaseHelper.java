package com.example.jeancarlos.snapfootball.Database;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.jeancarlos.snapfootball.Adapter.AnuncioAdapter;
import com.example.jeancarlos.snapfootball.Model.Anuncio;
import com.example.jeancarlos.snapfootball.Model.Usuario;
import com.example.jeancarlos.snapfootball.My_Interface.RecyclerViewOnClickListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Jean Carlos on 05/06/2017.
 */

public class FirebaseHelper {

    Context context;
    RecyclerView listView;
    DatabaseReference rootRef;
    ArrayList<Anuncio> receitaList= new ArrayList<>();
    AnuncioAdapter adapter;
    RecyclerViewOnClickListener recyclerViewOnClickListener;

    public FirebaseHelper(Context context, RecyclerViewOnClickListener recyclerViewOnClickListener, RecyclerView listView)
    {
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
        this.context= context;
        this.listView= listView;

        rootRef= FirebaseDatabase.getInstance().getReference();
    }

    public FirebaseHelper(Context context)
    {
        this.context= context;
        rootRef= FirebaseDatabase.getInstance().getReference("users");
    }

    /*public  void saveData(String nome, String ingredientes, String modoPreparo, Integer tempoPreparo,
                          Float nivelDificuldade, Integer quantidadePorcoes, String caminhoFoto) {

        String id = rootRef.push().getKey();
        Anuncio receita= new Anuncio(id, nome, ingredientes, modoPreparo, tempoPreparo,
                nivelDificuldade, quantidadePorcoes, caminhoFoto);
        rootRef.child("receita").push().setValue(receita);
    }



    public  void saveData(String nome, Float nivelDificuldade) {
       /* String id = rootRef.push().getKey();
        Receita receita= new Receita(id, nome, nivelDificuldade);
        rootRef.child(id).setValue(receita);

    } */

    public  void saveData(Usuario usuario) {
        if (usuario.getId_usuario()!=null){
            rootRef.child(usuario.getId_usuario()).setValue(usuario);
        }
        else{
            String id = rootRef.push().getKey();
            usuario.setId_usuario(id);
            rootRef.child(id).setValue(usuario);
        }
    }

    /*public void refreshData()
    {
        rootRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {

            }
        });
    }

    /*public void getUpdates(DataSnapshot dataSnapshot){

        receitaList.clear();

        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Receita receita= new Receita();
            receita.setId(ds.getValue(Receita.class).getId());
            receita.setNome(ds.getValue(Receita.class).getNome());
            receita.setNivelDificuldade(ds.getValue(Receita.class).getNivelDificuldade());

            receitaList.add(receita);
        }
        if(receitaList.size()>0){
            adapter = new ReceitaAdapter(context, receitaList);
            adapter.setRecyclerViewOnClickListener(recyclerViewOnClickListener);
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(context, "No data", Toast.LENGTH_SHORT).show();
        }
    }


    public static void deleteData(String id) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("receita").child(id);
        //removendo receita
        dR.removeValue();

    } */
}
