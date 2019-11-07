package com.example.android.trabajo4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button boton ;
    private EditText u, c;
    private final String Usuario = "Kevin";
    private final String PSW = "AleCapo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        u = findViewById(R.id.nom);
        c = findViewById(R.id.editText2);

        u.setText("");
        c.setText("");

        boton = findViewById(R.id.loginBTN);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = u.getText().toString();
                String psw = c.getText().toString();

                if (user.equals(Usuario) && psw.equals(PSW)) {
                    Intent i = new Intent (getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else {
                    u.setText("");
                    c.setText("");
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });
    }
}
