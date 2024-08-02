package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private final List<int[]> comList=new ArrayList<>();

    private int[] boxPositions={0,0,0,0,0,0,0,0,0};//9 zero

    private int playerTurn=1;

    private int selectedBox=1;
    TextView playerOneName,playerTwoName;
    LinearLayout playerOneLayout,playerTwoLayout;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playerOneName=findViewById(R.id.playerOneName);
        playerTwoName=findViewById(R.id.playerTwoName);

        playerOneLayout=findViewById(R.id.playerOneLayout);
        playerTwoLayout=findViewById(R.id.playerTwoLayoout);

        img1=findViewById(R.id.image1);
        img2=findViewById(R.id.image2);
        img3=findViewById(R.id.image3);
        img4=findViewById(R.id.image4);
        img5=findViewById(R.id.image5);
        img6=findViewById(R.id.image6);
        img7=findViewById(R.id.image7);
        img8=findViewById(R.id.image8);
        img9=findViewById(R.id.image9);

        comList.add(new int[] {0,1,2});
        comList.add(new int[] {3,4,5});
        comList.add(new int[] {6,7,8});
        comList.add(new int[] {0,3,6});
        comList.add(new int[] {1,4,7});
        comList.add(new int[] {2,5,8});
        comList.add(new int[] {2,4,6});
        comList.add(new int[] {0,4,8});

        String getPlayerOneName=getIntent().getStringExtra("one");
        String getPlayerTwoName=getIntent().getStringExtra("two");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(0)){
                    performAction((ImageView)v,0);
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(1)){
                    performAction((ImageView)v,1);
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(2)){
                    performAction((ImageView)v,2);
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(3)){
                    performAction((ImageView)v,3);
                }
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(4)){
                    performAction((ImageView)v,4);
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(5)){
                    performAction((ImageView)v,5);
                }
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(6)){
                    performAction((ImageView)v,6);
                }
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(7)){
                    performAction((ImageView)v,7);
                }
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isBoxSelect(8)){
                    performAction((ImageView)v,8);
                }
            }
        });
    }

    private void performAction(ImageView imageView,int selectedBoxPosition){

        boxPositions[selectedBoxPosition]=playerTurn;
        if (playerTurn==1){
            imageView.setImageResource(R.drawable.xicon);
            if (checkPlayerwin()){

                WinDialog winDialog=new WinDialog(GameActivity.this,playerOneName.getText().toString()+"has won the match",GameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if (selectedBox==9) {
                WinDialog winDialog=new WinDialog(GameActivity.this,"It is draw",GameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                selectedBox++;
            }
        }else {
            imageView.setImageResource(R.drawable.oicon);
            if (checkPlayerwin()){
                WinDialog winDialog=new WinDialog(GameActivity.this,playerTwoName.getText().toString()+"has won the match",GameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (selectedBox==9) {
                WinDialog winDialog=new WinDialog(GameActivity.this,"It is draw",GameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else{
                changePlayerTurn(1);
                selectedBox++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn=currentPlayerTurn;
        if (playerTurn==1){
            playerOneLayout.setBackgroundResource(R.drawable.round_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_blue);
        }else {
            playerTwoLayout.setBackgroundResource(R.drawable.round_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_blue);
        }
    }

    private boolean checkPlayerwin(){
        boolean response=false;
        for (int i=0;i<comList.size();i++){
            int[] combination=comList.get(i);
            if (boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return response;
    }
    private boolean isBoxSelect(int boxPosition){
        boolean response=false;
        if (boxPositions[boxPosition]==0){
            response=true;
        }
        return response;
    }

    void restartMatch(){
        boxPositions=new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        selectedBox=1;
        img1.setImageResource(R.drawable.round_blue);
        img2.setImageResource(R.drawable.round_blue);
        img3.setImageResource(R.drawable.round_blue);
        img4.setImageResource(R.drawable.round_blue);
        img5.setImageResource(R.drawable.round_blue);
        img6.setImageResource(R.drawable.round_blue);
        img7.setImageResource(R.drawable.round_blue);
        img8.setImageResource(R.drawable.round_blue);
        img9.setImageResource(R.drawable.round_blue);
    }

}