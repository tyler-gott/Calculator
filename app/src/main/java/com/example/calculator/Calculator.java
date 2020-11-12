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

    //when their respective button is pressed, it inputs that value into the insertValue method
    public void onNum0(View view) {
        insertValue("0");
    }

    public void onNum1(View view) {
        insertValue("1");
    }

    public void onNum2(View view) {
        insertValue("2");
    }

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
    }

    public void onNum9(View view) {
        insertValue("9");
    }

    //concatenates the display string with the inputted value
    private void insertValue(String inputValue) {
        displayString += inputValue;
        currentValue = Double.parseDouble(displayString); //updates the current value to be that of the displayed value
        setDisplay(displayString);
    }

    //outputs the new number as a string
    private void setDisplay(String displayString) {
        TextView view = findViewById(R.id.displayValue);
        view.setText(displayString);
    }

    //changes the operation to add and stores the last pressed value as lastValue
    public void onAdd(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "add";
    }

    //changes the operation to subtract and stores the last pressed value as lastValue
    public void onSubtract(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "subtract";
    }

    //changes the operation to multiply and stores the last pressed value as lastValue
    public void onMultiply(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "multiply";
    }

    //changes the operation to divide and stores the last pressed value as lastValue
    public void onDivide(View view) {
        lastValue = currentValue;
        currentValue = 0;
        displayString = ""; //clears the current value to allow for a new input
        operation = "divide";
    }

    //converts a decimal to a percent
    public void onPercent(View view) {
        currentValue *= 0.01;
        outFormat(currentValue);
    }

    //converts a positive to negative and vice versa
    public void onNegation(View v) {
        currentValue *= -1;
        outFormat(currentValue);
    }

    //inserts a decimal into a number
    public void onDecimal(View view) {
        if (displayString.equals("")) {
            insertValue("0.");
        } else {
            insertValue(".");
        }
    }

    public void onEquals(View view) {
        double outValue; //will be the number displayed post operation
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
                    setDisplay("Error: Div by 0");
                }
                else {
                    outValue = lastValue / currentValue;
                    currentValue = outValue;
                    outFormat(outValue);
                }
                break;
            }
            displayString = "";
    }

    //clears all stored numbers and operations
    public void onClear(View view) {
        operation = "";
        displayString = "";
        lastValue = 0;
        currentValue = 0;
        setDisplay("");
    }

    //visually displays the number as an integer if it is a whole number, removing unnecessary decimals
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
