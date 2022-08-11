package com.ahmadossama.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9, addBtn, subBtn,
            multiplyBtn, divideBtn, dotBtn,equalBtn, clearBtn, delBtn,plusMinusBtn;
    TextView text;
    float value1, value2;
    boolean isSub, isAdd,isMul, isDiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        btn0 = findViewById(R.id.b0);
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);
        addBtn = findViewById(R.id.add);
        subBtn = findViewById(R.id.subtract);
        multiplyBtn = findViewById(R.id.multiply);
        divideBtn = findViewById(R.id.divide);
        dotBtn = findViewById(R.id.dot);
        equalBtn = findViewById(R.id.equal);
        clearBtn = findViewById(R.id.clear);
        btn0.setOnClickListener(num_listener);
        btn1.setOnClickListener(num_listener);
        btn2.setOnClickListener(num_listener);
        btn3.setOnClickListener(num_listener);
        btn4.setOnClickListener(num_listener);
        btn5.setOnClickListener(num_listener);
        btn6.setOnClickListener(num_listener);
        btn7.setOnClickListener(num_listener);
        btn8.setOnClickListener(num_listener);
        btn9.setOnClickListener(num_listener);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text == null) {
                    text.setText("");
                } else {
                    value1 = Float.parseFloat(text.getText() + "");
                    isAdd = true;
                    text.setText(null);
                }
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text == null) {
                    text.setText("");
                } else {
                    value1 = Float.parseFloat(text.getText() + "");
                    isSub = true;
                    text.setText(null);
                }
                }
            });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text == null) {
                    text.setText("");
                } else {
                    value1 = Float.parseFloat(text.getText() + "");
                    isMul = true;
                    text.setText(null);
                }
            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text == null) {
                    text.setText("");
                } else {
                    value1 = Float.parseFloat(text.getText() + "");
                    isDiv = true;
                    text.setText(null);
                }
            }
        });
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = Float.parseFloat(text.getText() + "");

                if (isAdd == true) {
                    text.setText(value1 + value2 + "");
                    isAdd = false;
                }
                else if (isSub == true) {
                    text.setText(value1 - value2 + "");
                    isSub = false;
                }
                else if (isMul == true) {
                    text.setText(value1 * value2 + "");
                    isMul = false;
                }
                else if (isDiv == true) {
                    text.setText(value1 / value2 + "");
                    isDiv = false;
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });

    }
    View.onClickListener operation = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (operation){

            }
        }
    };
     View.OnClickListener num_listener = new View.OnClickListener() {
        @Override
        public void onClick(View ob1) {
            Button mybtn = (Button) ob1;
            String result = mybtn.getText().toString();
            int res = Integer.parseInt(result);
            Double x = Double.valueOf(result);
            text.append(result);

        }
    };


}