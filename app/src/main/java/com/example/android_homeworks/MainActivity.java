package com.example.android_homeworks;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        textViewX = findViewById(R.id.text_view_x);
    }
    private int getIntValue(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }

    public void click(View view) {
        if (editTextA.getText().toString().isEmpty() || editTextB.getText().toString().isEmpty() ||
                editTextC.getText().toString().isEmpty()) {
            Toast.makeText(this, "Введите все коэффициенты",Toast.LENGTH_SHORT).show();
        } else {
            int a = getIntValue(editTextA);
            int b = getIntValue(editTextB);
            int c = getIntValue(editTextC);
            double sqrtD = Math.sqrt((b * b) - 4 * a * c);
            if (a != 0) {
                if (sqrtD > 0) {
                    double x1 = ((double) b * (-1) + sqrtD) / (2 * (double) a);
                    double x2 = ((double) b * (-1) - sqrtD) / (2 * (double) a);
                    textViewX.setText(String.format("x1 = " + x1 + "\nx2 = " + x2));
                    //Toast.makeText(this, "x1 = " + x1 + "; x2 = " + x2,Toast.LENGTH_SHORT).show();
                } else if (sqrtD == 0) {
                    double x1 = ((double) b * (-1) + sqrtD) / (2 * (double) a);
                    textViewX.setText(String.format("x = " + x1));
                    //Toast.makeText(this, "x = " + x1,Toast.LENGTH_SHORT).show();
                } else {
                    textViewX.setText(String.format("Нет корней"));
                    //Toast.makeText(this, "Нет корней",Toast.LENGTH_SHORT).show();
                }
            } else {
                double x = (double) c / b;
                textViewX.setText(String.format("x = " + x));
            }
            //textViewX.setText(R.string.app_name);
        }
    }
}