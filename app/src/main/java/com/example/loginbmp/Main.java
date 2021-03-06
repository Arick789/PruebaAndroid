package com.example.loginbmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener {
    EditText UsuarioL, PasswordL;
    TextView olvidastecontraseña;
    Button entL, regisL;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Enlazamos las variables con sus respectivos botones o entradas
        UsuarioL = (EditText)findViewById(R.id.User);
        PasswordL = (EditText)findViewById(R.id.Password);
        entL=(Button)findViewById(R.id.btnIniciar);
        regisL=(Button)findViewById(R.id.btnRegistrarse);
        olvidastecontraseña = findViewById(R.id.olvidastecontra);

        //Se asignan los eventos
        entL.setOnClickListener(this);
        regisL.setOnClickListener(this);
        dao = new daoUsuario( this);
        olvidastecontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main.this, ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciar:
                //Recibir usuario y contraseña
                String u=UsuarioL.getText().toString();
                String p=PasswordL.getText().toString();
                //Si estan vacios, retorne error
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_LONG).show();
                    //Si estan los campos llenos y el usuario está registrado, inicia sesión
                }else if (dao.login(u,p)==1){
                    Usuario ux = dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Main.this, Inicio.class);
                    i2.putExtra("Id", ux.getId());
                            startActivity(i2);
                            finish();
                }else {
                    //si no se cumplen los anteriores nos muestra error por datos incorrectos o inexistentes
                    Toast.makeText(this, "Email y/o Password incorrectos", Toast.LENGTH_LONG).show();

                }
            break;

            case  R.id.btnRegistrarse:
                Intent i= new Intent(Main.this, Registro.class);
                startActivity(i);
                break;
        }
    }
}
