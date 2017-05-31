package com.example.jeancarlos.snapfootball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jeancarlos.snapfootball.DAO.UsuarioDAO;
import com.example.jeancarlos.snapfootball.Helper.UsuarioHelper;
import com.example.jeancarlos.snapfootball.Model.Usuario;

public class NewUsuarioActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_usuario);

        getSupportActionBar().hide();
    }
}
