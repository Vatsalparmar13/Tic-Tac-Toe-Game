package com.example.tictac;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    String meassage;
    GameActivity gameActivity;
    TextView txtmessage;
    Button startAgain;

    public WinDialog(@NonNull Context context,String message,GameActivity gameActivity) {
        super(context);
        this.meassage=message;
        this.gameActivity=gameActivity;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog_layout);

        txtmessage=findViewById(R.id.txtmessage);
        startAgain=findViewById(R.id.btn_stagain);

        txtmessage.setText(meassage);

        startAgain.setOnClickListener(v -> {
            gameActivity.restartMatch();
            dismiss();
        });

    }
}
