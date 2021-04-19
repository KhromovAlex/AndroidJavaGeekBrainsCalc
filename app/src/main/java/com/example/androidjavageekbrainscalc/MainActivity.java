package com.example.androidjavageekbrainscalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String CALC = "calc";
    private Calculator calculator;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.main__output_text);

        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else {
            calculator = savedInstanceState.getParcelable(CALC);
            resultTextView.setText(calculator.getLastOperand() == null ? "0" : calculator.getLastOperand());
        }

        findViewById(R.id.calc_button_0).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) return;
                calculator.setOperandOne(resultTextView.getText().toString() + "0");
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("0");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) return;
                calculator.setOperandTwo(resultTextView.getText().toString() + "0");
                resultTextView.setText(calculator.getLastOperand());
            }

        });
        findViewById(R.id.calc_button_00).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) return;
                if (resultTextView.getText().toString().equals("")) {
                    calculator.setOperandOne("0");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "00");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("0");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) return;
                if (resultTextView.getText().toString().equals("")) {
                    calculator.setOperandTwo("0");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "00");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_1).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("1");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "1");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("1");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("1");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "1");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_2).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("2");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "2");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("2");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("2");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "2");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_3).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("3");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "3");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("3");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("3");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "3");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_4).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("4");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "4");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("4");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("4");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "4");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_5).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("5");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "5");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("5");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("5");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "5");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_6).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("6");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "6");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("6");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("6");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "6");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_7).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("7");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "7");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("7");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("7");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "7");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_8).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("8");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "8");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("8");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("8");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "8");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_9).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandOne("9");
                } else {
                    calculator.setOperandOne(resultTextView.getText().toString() + "9");
                }
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() == null) {
                calculator.setOperandTwo("9");
                resultTextView.setText(calculator.getLastOperand());
            } else {
                if (resultTextView.getText().toString().equals("0")) {
                    calculator.setOperandTwo("9");
                } else {
                    calculator.setOperandTwo(resultTextView.getText().toString() + "9");
                }
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_dot).setOnClickListener(v -> {
            if (calculator.getOperator() == null) {
                if (resultTextView.getText().toString().contains(".") || resultTextView.getText().toString().equals(""))
                    return;
                calculator.setOperandOne(resultTextView.getText().toString() + ".");
                resultTextView.setText(calculator.getLastOperand());
            } else if (calculator.getOperandTwo() != null) {
                if (resultTextView.getText().toString().contains(".") || resultTextView.getText().toString().equals(""))
                    return;
                calculator.setOperandTwo(resultTextView.getText().toString() + ".");
                resultTextView.setText(calculator.getLastOperand());
            }
        });
        findViewById(R.id.calc_button_divide).setOnClickListener(v -> {
            if (calculator.getOperandOne() == null || calculator.getOperandOne().equals("-"))
                return;
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                resultTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.DIVIDE);
        });
        findViewById(R.id.calc_button_multiply).setOnClickListener(v -> {
            if (calculator.getOperandOne() == null || calculator.getOperandOne().equals("-"))
                return;
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                resultTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.MULTIPLY);
        });
        findViewById(R.id.calc_button_minus).setOnClickListener(v -> {
            if (calculator.getOperandTwo() == null && calculator.getOperandOne() == null || calculator.getOperandOne().equals("") || calculator.getOperandOne().equals("-")) {
                calculator.setOperandOne("-");
                resultTextView.setText(calculator.getLastOperand());
                return;
            }
            if (calculator.getOperandOne().equals("0") && calculator.getOperandTwo() == null) {
                calculator.setOperandOne("-0");
                resultTextView.setText(calculator.getLastOperand());
                return;
            }
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                resultTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.MINUS);
        });
        findViewById(R.id.calc_button_plus).setOnClickListener(v -> {
            if (calculator.getOperandOne() == null || calculator.getOperandOne().equals("-"))
                return;
            if (calculator.getOperandTwo() != null) {
                calculator.calculate();
                resultTextView.setText(calculator.getLastOperand());
            }
            calculator.setOperator(CalculatorOperators.PLUS);
        });
        findViewById(R.id.calc_button_remove_all).setOnClickListener(v -> {
            calculator.clearData();
            resultTextView.setText("");
        });
        findViewById(R.id.calc_button_equals).setOnClickListener(v -> {
            calculator.calculate();
            resultTextView.setText(calculator.getLastOperand());
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CALC, calculator);
        super.onSaveInstanceState(outState);
    }
}