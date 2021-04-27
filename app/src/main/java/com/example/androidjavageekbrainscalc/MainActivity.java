package com.example.androidjavageekbrainscalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String CALC = "calc";
    private Calculator calculator;
    private TextView outputTextView;
    private String resultText;
    private final int[] numberButtonIds = new int[]{R.id.calc_button_0, R.id.calc_button_1, R.id.calc_button_2, R.id.calc_button_3,
            R.id.calc_button_4, R.id.calc_button_5, R.id.calc_button_6, R.id.calc_button_7, R.id.calc_button_8, R.id.calc_button_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTextView = findViewById(R.id.main__output_text);

        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else {
            calculator = savedInstanceState.getParcelable(CALC);
            outputTextView.setText(calculator.getLastOperand() == null ? "0" : calculator.getLastOperand());
        }

        setNumberButtonListeners();

        findViewById(R.id.calc_button_00).setOnClickListener(v -> {
            resultText = outputTextView.getText().toString();

            if (calculator.getOperator() == null) {
                if (resultText.equals("0")) return;
                if (resultText.equals("")) {
                    calculator.setOperandOne("0");
                } else {
                    calculator.setOperandOne(resultText + "00");
                }
                outputTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("0");
                outputTextView.setText(calculator.getLastOperand());
            } else {
                if (resultText.equals("0")) return;
                if (resultText.equals("")) {
                    calculator.setOperandTwo("0");
                } else {
                    calculator.setOperandTwo(resultText + "00");
                }
                outputTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_dot).setOnClickListener(v -> {
            resultText = outputTextView.getText().toString();

            if (calculator.getOperator() == null) {
                if (resultText.contains(".") || resultText.equals(""))
                    return;
                calculator.setOperandOne(resultText + ".");
                outputTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() != null) {
                if (resultText.contains(".") || resultText.equals(""))
                    return;
                calculator.setOperandTwo(resultText + ".");
                outputTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_divide).setOnClickListener(v -> {
            if (calculator.getOperandOne() == null || calculator.getOperandOne().equals("-"))
                return;
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                outputTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.DIVIDE);
        });
        findViewById(R.id.calc_button_multiply).setOnClickListener(v -> {
            if (calculator.getOperandOne() == null || calculator.getOperandOne().equals("-"))
                return;
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                outputTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.MULTIPLY);
        });
        findViewById(R.id.calc_button_minus).setOnClickListener(v -> {
            if (calculator.getOperandTwo() == null && calculator.getOperandOne() == null || calculator.getOperandOne().equals("") || calculator.getOperandOne().equals("-")) {
                calculator.setOperandOne("-");
                outputTextView.setText(calculator.getLastOperand());
                return;
            }
            if (calculator.getOperandOne().equals("0") && calculator.getOperandTwo() == null) {
                calculator.setOperandOne("-0");
                outputTextView.setText(calculator.getLastOperand());
                return;
            }
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                outputTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.MINUS);
        });
        findViewById(R.id.calc_button_plus).setOnClickListener(v -> {
            if (calculator.getOperandOne() == null || calculator.getOperandOne().equals("-"))
                return;
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                outputTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.PLUS);
        });
        findViewById(R.id.calc_button_remove_all).setOnClickListener(v -> {
            calculator.clearData();
            outputTextView.setText("");
        });
        findViewById(R.id.calc_button_equals).setOnClickListener(v -> {
            calculator.calculate();
            outputTextView.setText(calculator.getLastOperand());
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CALC, calculator);
        super.onSaveInstanceState(outState);
    }

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            int index = i;
            findViewById(numberButtonIds[i]).setOnClickListener(v -> onNumberClick(index));
        }
    }

    private void onNumberClick(int number) {
        String valueNumber = "" + number;
        String resultStr = outputTextView.getText().toString();
        if (calculator.getOperator() == null) {
            if (resultStr.equals("0")) {
                calculator.setOperandOne(valueNumber);
            } else {
                calculator.setOperandOne(resultStr + valueNumber);
            }
        } else if (calculator.getOperandTwo() == null) {
            calculator.setOperandTwo(valueNumber);
        } else {
            if (resultStr.equals("0")) {
                calculator.setOperandTwo(valueNumber);
            } else {
                calculator.setOperandTwo(resultStr + valueNumber);
            }
        }
        outputTextView.setText(calculator.getLastOperand());
    }
}
