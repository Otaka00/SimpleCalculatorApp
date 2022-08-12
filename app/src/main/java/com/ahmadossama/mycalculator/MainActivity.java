package com.ahmadossama.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String Prefs_name = "PreferencesFile";
    String op = "+";
    String firstNum ="";
    double result = 0.0;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9, addBtn, subBtn,
            multiplyBtn, divideBtn, dotBtn,equalBtn, clearBtn, delBtn,plusMinusBtn,
            memoryPlus,memoryMinus,memoryRecall,memoryClear;
    TextView text;
    float value1, value2;
    boolean isSub, isAdd,isMul, isDiv, isNew = true;
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
        plusMinusBtn = findViewById(R.id.plusMin);
        addBtn = findViewById(R.id.add);
        subBtn = findViewById(R.id.subtract);
        multiplyBtn = findViewById(R.id.multiply);
        divideBtn = findViewById(R.id.divide);
        dotBtn = findViewById(R.id.dot);
        equalBtn = findViewById(R.id.equal);
        clearBtn = findViewById(R.id.clear);
        memoryPlus =findViewById(R.id.MPlus);
        memoryMinus =findViewById(R.id.MMinus);
        memoryRecall =findViewById(R.id.MR);
        memoryClear =findViewById(R.id.MC);
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
        dotBtn.setOnClickListener(num_listener);
        plusMinusBtn.setOnClickListener(num_listener);
        equalBtn.setOnClickListener(equal_listener);
        addBtn.setOnClickListener(operation_listener);
        subBtn.setOnClickListener(operation_listener);
        multiplyBtn.setOnClickListener(operation_listener);
        divideBtn.setOnClickListener(operation_listener);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("0");
                isNew = true;
            }
        });
//        memoryPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences settings = getSharedPreferences(Prefs_name, 0);
//                SharedPreferences.Editor editor = settings.edit();
//                editor.putString("value", text.getText().toString());
//                editor.commit();
//                name2.setText(settings.getString("name", "Name not found"));
//                email2.setText(settings.getString("email", "Email not found"));
//            }
//        });
    }
    View.OnClickListener operation_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button opBtn = (Button) view;
            isNew = true;
            firstNum = text.getText().toString();
            op = opBtn.getText().toString();
        }
    };

    View.OnClickListener num_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isNew){
                text.setText("");
            }
            isNew = false;
            Button mybtn = (Button) view;
            String number = text.getText().toString();
            if(mybtn == plusMinusBtn){
                number = "-" + number;
            }else number += mybtn.getText().toString();
            text.setText(number);
        }
    };
    View.OnClickListener equal_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String secondNum = text.getText().toString();
            switch (op){
                case "+":
                    result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum); break;
                case "-":
                    result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum); break;
                case "x":
                    result = (Double.parseDouble(firstNum) * Double.parseDouble(secondNum)); break;
                case "/":
                    result = (Double.parseDouble(firstNum) / Double.parseDouble(secondNum)); break;
            }
            text.setText(result + "");
        }
    };
}