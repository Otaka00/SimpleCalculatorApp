package com.ahmadossama.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String op = "+";
    String firstNum ="";
    double result = 0.0,tempResult= 0.0, memory = 0.0;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9, addBtn, subBtn, multiplyBtn,
    divideBtn,dotBtn,equalBtn,clearBtn,plusMinusBtn,memoryPlus,memoryMinus,memoryRecall,memoryClear;
    ImageButton delBtn;
    TextView text;
    //3 decimal places as maximum format
    private static final DecimalFormat df = new DecimalFormat("0.000");
    boolean isNew = true;
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
        delBtn = findViewById(R.id.delete);
        memoryPlus.setOnClickListener(memory_listener);
        memoryMinus.setOnClickListener(memory_listener);
        memoryRecall.setOnClickListener(memoryRecall_listener);
        memoryClear.setOnClickListener(memoryClr_listener);
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
        addBtn.setOnClickListener(operation_listener);
        subBtn.setOnClickListener(operation_listener);
        multiplyBtn.setOnClickListener(operation_listener);
        divideBtn.setOnClickListener(operation_listener);
        equalBtn.setOnClickListener(equal_listener);
        delBtn.setOnClickListener(del_listener);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
                isNew = true;
            }
        });
    }
    //Adding and subtracting value from the memory
    View.OnClickListener memory_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //if displayed text is empty, return without adding nothing to memory
            if(text.getText().toString().equals("")){
                return;
            }
            Button btn = (Button)view;
            String command = btn.getText().toString();
            String displayText = text.getText().toString();
            if(command.equals("M+")){
                //Add value to memory
                if(displayText.indexOf("+") != -1 && displayText.indexOf("=") == -1){
                    //use this case if the output is showing full equation
                    return;
                }
                else if(displayText.indexOf("=")!=-1){
                    //if a full equation, add tempResult to memory then reset
                    memory += tempResult;
                    tempResult = 0;
                }
                else{
                    memory += Double.parseDouble(displayText);
                }
                Toast.makeText(MainActivity.this,
                        memory +" is added to the memory",Toast.LENGTH_SHORT).show();
            }
            else{
                //Subtract value from memory
                if(displayText.indexOf("+") != -1 && displayText.indexOf("=") == -1){
                    //use this case if the output is showing full equation
                    return;
                }
                else if(displayText.indexOf("=")!=-1){
                    memory -= tempResult;
                    tempResult = 0;
                }
                else{memory -= Double.parseDouble(displayText);}
                Toast.makeText(MainActivity.this,
                        memory +" is subtracted from the memory",Toast.LENGTH_SHORT).show();
            }

        }
    };
    //Retrieve the stored value in the memory
    View.OnClickListener memoryRecall_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            text.setText(memory+"");
            Toast.makeText(MainActivity.this,
                    memory +" is recalled from the memory",Toast.LENGTH_SHORT).show();
        }
    };
    //reset value stored in the memory
    View.OnClickListener memoryClr_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            memory = 0;
            Toast.makeText(MainActivity.this,
                    "Memory is cleared" ,Toast.LENGTH_SHORT).show();
        }
    };
    ////////////////////////////////////////////////////////////////////
    //Operations Button Handler
    View.OnClickListener operation_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button opBtn = (Button) view;
            isNew = true;
            firstNum = text.getText().toString();
            op = opBtn.getText().toString();
        }
    };
    //Numbers Buttons Handler
    View.OnClickListener num_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button mybtn = (Button) view;
            //If dot button is clicked at the start of the text field zero will not be cleared
            if(text.getText().toString().equals("0") && mybtn.equals(dotBtn)){
                String number = text.getText().toString();
                number += mybtn.getText().toString();
                text.setText(number);
                return;
            }
            //if new operand is typed, text field is reset and isNew boolean value will be switched
                if (isNew) {
                    text.setText("");
                }
                isNew = false;
                //Prevent zero or dot button from being pressed more than one time
                //to prevent exceptions in decimal numbers by escaping the function
                if ((text.getText().toString().equals("0") && mybtn.equals(btn0)) ||
                        (text.getText().toString().contains(".") && mybtn.equals(dotBtn))) {
                    return;}
                else {
                    String number = text.getText().toString();
                    if (mybtn == plusMinusBtn) {
                        // Check if the number is not -ve to add the sign and remove it if -ve
                        if (!number.startsWith("-"))
                            number = "-" + number;
                        else
                            number = number.substring(1);
                    }
                    else number += mybtn.getText().toString();
                    text.setText(number);
                }
            }
    };
    //Equal Button handler after finishing the equation
    View.OnClickListener equal_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String secondNum = text.getText().toString();
            if (firstNum.equals("") || op.equals("")){
                text.setText(secondNum + "");
                return; }
            else {
                switch (op) {
                    case "+":
                        result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
                        break;
                    case "-":
                        result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
                        break;
                    case "x":
                        result = (Double.parseDouble(firstNum) * Double.parseDouble(secondNum));
                        break;
                    case "/":
                        result = (Double.parseDouble(firstNum) / Double.parseDouble(secondNum));
                        break;
                }
                String s = result +"";
                if(s.equals("Infinity")){
                    //If result value is infinity, just print it and exit the function
                    //Infinity value could not be rounded
                    text.setText((result) + "");
                    Toast.makeText(MainActivity.this, firstNum + " " + op + " " +
                                    secondNum + " : undefined", Toast.LENGTH_SHORT).show();
                    return;
                }
                String[] splitter = s.split("\\.");
                int after = splitter[1].length();
                //Count number of decimal points in the result and print only 4 digits
                if(after > 3){
                    text.setText(df.format(result) + "");
                }
                else text.setText((result) + "");
                Toast.makeText(MainActivity.this, firstNum + " " + op + " " + secondNum,
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
    View.OnClickListener del_listener = new View.OnClickListener() {
        @Override public void onClick(View view) {
            String currentVal = text.getText().toString();
            //if text field is empty, do nothing and exit from the function
             if (currentVal.equals("")) {
                 return;
             }
             else {
                 // remove last character
                 String newValue = currentVal.substring(0, currentVal.length() - 1);
                 text.setText(newValue);
             }
        }

    };
}