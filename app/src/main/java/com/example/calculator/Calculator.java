package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private String currentValue = "";
    private String lastValue = "";
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void insertNumber(int num) {
        currentValue += num;
        setDisplay(currentValue);
    }

    private void setDisplay(String str) {
        TextView view = (TextView)findViewById(R.id.displayValue);
        view.setText(str);
    }

    public void onNum1(View view) {
        insertNumber(1);
    }

    public void onNum2(View view) {
        insertNumber(2);
    } //changed insertNumber(4) to insertNumber(2)

    public void onNum3(View view) {
        insertNumber(3);
    }

    public void onNum4(View view) {
        insertNumber(4);
    }

    public void onNum5(View view) {
        insertNumber(5);
    }

    public void onNum6(View view) {
        insertNumber(6);
    }

    public void onNum7(View view) {
        insertNumber(7);
    }

    public void onNum8(View view) {
        insertNumber(8);
    } //changed insertNumber(0) to insertNumber(8)

    public void onNum9(View view) {
        insertNumber(9);
    }

    public void onNum0(View view) {
        insertNumber(0);
    }

    public void onAdd(View view) {
        lastValue = currentValue;
        currentValue = ""; //clears the current value to allow for a new input
        operation = "add";
    }

    public void onSubtract(View view) {
        lastValue = currentValue;
        currentValue = ""; //clears the current value to allow for a new input
        operation = "subtract";
    }

    public void onMultiply(View view) {
        lastValue = currentValue;
        currentValue = ""; //clears the current value to allow for a new input
        operation = "multiply";
    }

    public void onDivide(View view) {
        lastValue = currentValue;
        currentValue = ""; //clears the current value to allow for a new input
        operation = "divide";
    }

    public void onEquals(View view) {
        if(lastValue.length() > 0 && currentValue.length() > 0) {
            int val1 = Integer.parseInt(lastValue);
            int val2 = Integer.parseInt(currentValue);

            int newValue = 0;
            switch (operation) {
                case "add":
                    newValue = val1 + val2;
                    setDisplay(Integer.toString(newValue));
                    break;
                case "subtract":
                    newValue = val1 - val2; //changed '+' to '-'
                    setDisplay(Integer.toString(newValue));
                    break;
                case "multiply":
                    newValue = val1 * val2; //changed '/' to '*'
                    setDisplay(Integer.toString(newValue));
                    break;
                case "divide": //changed from "divider" to "divide"
                    if (val2 == 0) {
                        setDisplay("Error: Div by 0");; //moved setDisplay to each case to prevent division by 0
                    }
                    else {
                        newValue = val1 / val2;
                        setDisplay(Integer.toString(newValue));
                    }
                    break;
            }
            //clears last and currentValues for next input
            lastValue = "";
            currentValue = "";
        }
    }

    public void onClear(View view) {
        operation = "";
        currentValue = "";
        lastValue = "";
        setDisplay(""); //added to clear the display when clear is pressed
    }
}
