package com.example.constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnlogin ;
    EditText username;
    EditText password;
    TextView username1;
    TextView password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        getView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username1.setText(username.getText().toString().trim());
                password1.setText(password.getText().toString().trim());
            }
        });
        TextView btn =(TextView)findViewById(R.id.textviewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "You have been redirected to the registration page.",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getView(){
        btnlogin = findViewById(R.id.btnlogin);
        username = findViewById(R.id.InputUsernameLogin);
        password = findViewById(R.id.InputPasswordLogin);
        username1 = findViewById(R.id.textViewUsername);
        password1 = findViewById(R.id.TextviewPassword);
    }
}