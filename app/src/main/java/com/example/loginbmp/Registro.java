package com.example.loginbmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText us, ema, nom, ape, pas;
    Button regR, canR;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        us = (EditText)findViewById(R.id.RegUser);
        pas = (EditText)findViewById(R.id.PasswordR);
        ema = (EditText)findViewById(R.id.EmailR);
        nom = (EditText)findViewById(R.id.NombreR);
        ape = (EditText)findViewById(R.id.ApellidoR);
        regR=(Button)findViewById(R.id.btnRegistrar);
        canR=(Button)findViewById(R.id.btnCancelar);

        regR.setOnClickListener(this);
        canR.setOnClickListener(this);
        dao= new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrar:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setEmail(ema.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ape.getText().toString());
                //Validar si hay campos vacios
                if(!u.isNull()){
                    Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)){
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(Registro.this, Main.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnCancelar:
                Intent i= new Intent(Registro.this, Main.class);
                startActivity(i);
                finish();
                break;
        }

    }
}