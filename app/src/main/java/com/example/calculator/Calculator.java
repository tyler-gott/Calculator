package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private String dispValue = ""; //what is displayed on the output screen
    private String lastValue = "";
    private double currentValue = 0;
    private double tempValue = 0;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }

    private void insertValue(String inputValue) {
        dispValue += inputValue;
        currentValue = Double.parseDouble(dispValue);
        setDisp(dispValue);
    }

    private void setDisp(String str) {
        TextView view = (TextView)findViewById(R.id.displayValue);
        view.setText(str);
    }

    public void onInvert(View v) {
        currentValue *= -1;
        dispValue = Double.toString(currentValue);
    }

    public void onDecimal(View view) {
        insertValue(".");
    }

    public void onNum0(View view) {
        insertValue("0");
    }

    public void onNum1(View view) {
        insertValue("1");
    }

    public void onNum2(View view) {
        insertValue("2");
    } //changed insertValue(4) to insertValue(2)

    public void onNum3(View view) {
        insertValue("3");
    }

    public void onNum4(View view) {
        insertValue("4");
    }

    public void onNum5(View view) {
        insertValue("5");
    }

    public void onNum6(View view) {
        insertValue("6");
    }

    public void onNum7(View view) {
        insertValue("7");
    }

    public void onNum8(View view) {
        insertValue("8");
    } //changed insertValue(0) to insertValue(8)

    public void onNum9(View view) {
        insertValue("9");
    }

    public void onAdd(View view) {
        lastValue = dispValue;
        dispValue = ""; //clears the current value to allow for a new input
        operation = "add";
    }

    public void onSubtract(View view) {
        lastValue = dispValue;
        dispValue = ""; //clears the current value to allow for a new input
        operation = "subtract";
    }

    public void onMultiply(View view) {
        lastValue = dispValue;
        dispValue = ""; //clears the current value to allow for a new input
        operation = "multiply";
    }

    public void onDivide(View view) {
        lastValue = dispValue;
        dispValue = ""; //clears the current value to allow for a new input
        operation = "divide";
    }

    public void onPercent(View view) {
        lastValue = dispValue;

    }

    public void onEquals(View view) {
        if(lastValue.length() > 0 && dispValue.length() > 0) {
            int val1 = Integer.parseInt(lastValue);
            int val2 = Integer.parseInt(dispValue);

            int newValue = 0;
            switch (operation) {
                case "add":
                    newValue = val1 + val2;
                    setDisp(Integer.toString(newValue));
                    break;
                case "subtract":
                    newValue = val1 - val2; //changed '+' to '-'
                    setDisp(Integer.toString(newValue));
                    break;
                case "multiply":
                    newValue = val1 * val2; //changed '/' to '*'
                    setDisp(Integer.toString(newValue));
                    break;
                case "divide": //changed from "divider" to "divide"
                    if (val2 == 0) {
                        setDisp("Error: Div by 0");; //moved setDisplay to each case to prevent division by 0
                    }
                    else {
                        newValue = val1 / val2;
                        setDisp(Integer.toString(newValue));
                    }
                    break;
            }
            //clears last and dispValues for next input
            lastValue = "";
            dispValue = "";
        }
    }

    public void onClear(View view) {
        operation = "";
        dispValue = "";
        lastValue = "";
        setDisp(""); //added to clear the display when clear is pressed
    }
}
