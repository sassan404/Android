package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    String firstValue = "",
            secondValue = "",
            currentValue = "";
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    public void onClick(View view){
        TextView row = findViewById(R.id.tableRow);
        String text = row.getText() + getText(view);
        row.setText(text);
    }
    public void onNumber(View view){
        String text = getText(view);
        currentValue = currentValue + text;
        onClick(view);
    }
    public void onAdd(View view){
        firstValue = new String(currentValue);
        currentValue = "";
        operation = "Add";
        onClick(view);
    }
    public void onSubtract(View view){
        if(currentValue.length()==0){
            onNumber(view);
        } else {
            firstValue = new String(currentValue);
            currentValue = "";
            operation = "Subtract";
            onClick(view);
        }
    }
    public void onMultiply(View view){
        if(currentValue.length()==0) return;
        firstValue = new String(currentValue);
        currentValue = "";
        operation = "Multiply";
        onClick(view);
    }
    public void onDivide(View view){
        if(currentValue.length()==0) return;
        firstValue = new String(currentValue);
        currentValue = "";
        operation = "Divide";
        onClick(view);
    }

    public void onEqual(View view){
        TextView answer = findViewById(R.id.textView2);
        secondValue = new String(currentValue);
        currentValue = "";
        answer.setText(getResult(firstValue, secondValue));
        TextView row = findViewById(R.id.tableRow);
        String text = row.getText() + "\n";
        row.setText(text);
    }
    public void onClear(View view){
        TextView row = findViewById(R.id.tableRow);
        row.setText("");
    }
    public String getText(View view){
        Button button = findViewById(view.getId());
        return button.getText().toString();
    }
    public String getResult(String firstValue, String secondValue){
        switch (operation){
            case "Add": return String.valueOf(Double.parseDouble(firstValue) + Double.parseDouble(secondValue));
            case "Subtract": return String.valueOf(Double.parseDouble(firstValue) - Double.parseDouble(secondValue));
            case "Multiply": return String.valueOf(Double.parseDouble(firstValue) * Double.parseDouble(secondValue));
            case "Divide": return String.valueOf(Double.parseDouble(firstValue) / Double.parseDouble(secondValue));
            default: return "";
        }
    }
}
