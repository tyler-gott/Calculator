package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private String displayString = ""; //what is displayed on the output screen
    private double currentValue = 0;
    private double lastValue = 0;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }

    private void insertValue(String inputValue) {
        displayString += inputValue;
        currentValue = Double.parseDouble(displayString);
        setDisplay(displayString);
    }

    private void setDisplay(String displayString) {
        TextView view = findViewById(R.id.displayValue);
        view.setText(displayString);
    }

    public void onInvert(View v) {
        currentValue *= -1;
        displayString = Double.toString(currentValue);
        setDisplay(displayString);
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
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "add";
    }

    public void onSubtract(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "subtract";
    }

    public void onMultiply(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "multiply";
    }

    public void onDivide(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "divide";
    }

    public void onPercent(View view) {
        currentValue *= 0.01;
        displayString = Double.toString(currentValue);
        setDisplay(displayString);


    }

    public void onEquals(View view) {
        double outValue;
        switch (operation) {
            case "add":
                outValue = lastValue + currentValue;
                currentValue = outValue;
                outFormat(outValue);
                break;
            case "subtract":
                outValue = lastValue - currentValue;
                currentValue = outValue;
                outFormat(outValue);
                break;
            case "multiply":
                outValue = lastValue * currentValue;
                currentValue = outValue;
                outFormat(outValue);
                break;
            case "divide":
                if (currentValue == 0) {
                    setDisplay("Error: Div by 0"); //moved setDisplay to each case to prevent division by 0
                }
                else {
                    outValue = lastValue / currentValue;
                    currentValue = outValue;
                    outFormat(outValue);
                }
                break;
            }
            displayString = ""; //clears last and displayString
    }

    public void onClear(View view) {
        operation = "";
        displayString = "";
        lastValue = 0;
        currentValue = 0;
        setDisplay(""); //clears the display when clear is pressed
    }

    public void outFormat(double outValue) {
        if (Math.floor(outValue)==outValue) {
            int outInt = (int) outValue;
            displayString = Integer.toString(outInt);
        } else {
            displayString = String.format("%.7s", outValue);
        }
        setDisplay(displayString);
    }
}
