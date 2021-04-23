package com.example.loginbmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {
    Button recuperar;
    TextView usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        recuperar = findViewById(R.id.btnRecuperar);
        usu = findViewById(R.id.UserRecuperar);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ForgotPassword.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
    }
}