package com.andrey.tugas1_pkkm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etId = (EditText) findViewById(R.id.etId);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        TextView status = (TextView) findViewById(R.id.statusLogin);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);






        DBUser dbUser = new DBUser(this);


        dbUser.selct();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User u = dbUser.findUser();

                Log.d("hmzz", String.valueOf(u.getUsername()));

                if (String.valueOf(u.getUserId()).equals(etId.getText().toString()) && u.getUsername().equals(etUsername.getText().toString())){
                    status.setText("Login Berhasil");
                } else {
                    status.setText("Login Gagal");
                }
            }
        });


    }
}