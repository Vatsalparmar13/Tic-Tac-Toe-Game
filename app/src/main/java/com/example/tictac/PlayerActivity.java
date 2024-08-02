package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    EditText playerOne,playerTwo;
    TextView txt;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        txt=findViewById(R.id.txt1);
        playerOne=findViewById(R.id.ed_playerOne);
        playerTwo=findViewById(R.id.ed_playertwo);
        btnStart=findViewById(R.id.startGameButton);

        btnStart.setOnClickListener(v -> {
            String getplayerOne=playerOne.getText().toString();
            String getplayerTwo=playerTwo.getText().toString();

            if (getplayerOne.isEmpty() || getplayerTwo.isEmpty()){
                Toast.makeText(PlayerActivity.this, "Please,Enter player name", Toast.LENGTH_SHORT).show();
            }else {
                Intent startintent=new Intent(PlayerActivity.this, GameActivity.class);
                startintent.putExtra("one",getplayerOne);
                startintent.putExtra("two",getplayerTwo);
                startActivity(startintent);
            }
        });
    }
}