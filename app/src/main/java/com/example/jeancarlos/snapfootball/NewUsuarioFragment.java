package com.example.jeancarlos.snapfootball;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeancarlos.snapfootball.DAO.UsuarioDAO;
import com.example.jeancarlos.snapfootball.Database.FirebaseHelper;
import com.example.jeancarlos.snapfootball.Helper.UsuarioHelper;
import com.example.jeancarlos.snapfootball.Model.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NewUsuarioFragment extends Fragment {

    UsuarioHelper helper;
    FirebaseHelper helperDatabase;

    DatabaseReference rootRef, demoRef;

    public NewUsuarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_usuario, container, false);

        helper = new UsuarioHelper(v);

        Intent intent = getActivity().getIntent();
        final Usuario usuario = (Usuario) intent.getSerializableExtra("goNewUsuario");
        final EditText username = (EditText) v.findViewById(R.id.editUsername);
        final EditText email = (EditText) v.findViewById(R.id.editEmail);
        final EditText senha = (EditText) v.findViewById(R.id.editSenha);
        final EditText senha2 = (EditText) v.findViewById(R.id.editSenha2);


        Button btnSave = (Button) v.findViewById(R.id.btnCriarConta);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Usuario newUsuario = helper.getUsuario();
                UsuarioDAO dao = new UsuarioDAO(getActivity());

                if (senha2.getText().toString().equals(senha.getText().toString())) {
                    dao.insertUsuario(newUsuario);
                    dao.close();

                    Toast.makeText(getActivity(), "Usuário " + newUsuario.getUsername() + " cadastrado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "As senhas não conicidem", Toast.LENGTH_LONG).show();
                } */

               helperDatabase = new FirebaseHelper(getContext());

                Usuario usu = new Usuario();

                usu.setUsername(username.getText().toString());
                usu.setEmail(email.getText().toString());
                usu.setSenha(senha.getText().toString());

                helperDatabase.saveData(usu);

                Toast.makeText(getActivity(), "uehuehe", Toast.LENGTH_LONG).show();




                getActivity().finish();
            }
        });


        return v;
    }


}
