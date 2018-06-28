package com.jabinho.jogodavelha;

import android.content.DialogInterface;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button[] arrayButton = new Button[10];
    private String vez = "X";
    private int jogadas = 0;
    private String[] matriz = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializabotao();
        onClickButton();
    }
//Inicialização dos botões
    private void inicializabotao(){

            arrayButton[1] = findViewById(R.id.btn1);
            arrayButton[2] = findViewById(R.id.btn2);
            arrayButton[3] = findViewById(R.id.btn3);
            arrayButton[4] = findViewById(R.id.btn4);
            arrayButton[5] = findViewById(R.id.btn5);
            arrayButton[6] = findViewById(R.id.btn6);
            arrayButton[7] = findViewById(R.id.btn7);
            arrayButton[8] = findViewById(R.id.btn8);
            arrayButton[9] = findViewById(R.id.btn9);


    }

    // Colocar o X ou 0 no botão clicado
    private void onClickButton(){
        for (int x=1; x<10;x++){
            Button reset = findViewById(R.id.btnreset);
            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recomecar();

                }
            });

            final int finalX = x;
            arrayButton[finalX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jogada(finalX);
                }
            });
            matriz[x]="";
        }
    }
    private void jogada(int x){
        if (matriz[x].equals("")){
            matriz[x] = vez;
            jogadas++;
                if (vez.equals("x") || vez.equals("X")){
                    vez = "O";
                } else {
                    vez= "x";
                }
        }
    exibirButtons();
    }
    private void exibirButtons(){
        for (int x =1; x<10; x++){
            arrayButton[x].setText(matriz[x]);
        }
    }

    private void recomecar(){
        jogadas=0;
        for (int x =1; x<10; x++) {
        matriz[x] = "";
        }
        exibirButtons();
        }

}
