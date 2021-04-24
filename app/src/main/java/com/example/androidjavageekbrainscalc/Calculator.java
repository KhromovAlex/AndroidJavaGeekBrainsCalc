package com.example.androidjavageekbrainscalc;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {
    private String operandOne;
    private String operandTwo;
    private CalculatorOperators operator;

    public Calculator() {
    }

    protected Calculator(Parcel in) {
        operandOne = in.readString();
        operandTwo = in.readString();
        try {
            operator = CalculatorOperators.values()[in.readInt()];
        } catch (Exception e) {
            operator = null;
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(operandOne);
        dest.writeString(operandTwo);
        try {
            dest.writeInt(operator.ordinal());
        } catch (Exception e) {
            dest.writeInt(Integer.MIN_VALUE);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public String getOperandOne() {
        return operandOne;
    }

    public String getOperandTwo() {
        return operandTwo;
    }

    public String getLastOperand() {
        return operandTwo == null ? operandOne : operandTwo;
    }

    public void setOperandOne(String operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperandTwo(String operandTwo) {
        this.operandTwo = operandTwo;
    }

    public CalculatorOperators getOperator() {
        return operator;
    }

    public void setOperator(CalculatorOperators operator) {
        this.operator = operator;
    }

    private double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public void calculate() {
        if (operandOne == null || operandTwo == null) {
            return;
        }
        switch (operator) {
            case PLUS: {
                double result = parseDouble(operandOne) + parseDouble(operandTwo);
                operator = null;
                operandOne = result + "";
                operandTwo = null;
                return;
            }
            case MINUS: {
                double result = parseDouble(operandOne) - parseDouble(operandTwo);
                operator = null;
                operandOne = result + "";
                operandTwo = null;
                return;
            }
            case MULTIPLY: {
                double result = parseDouble(operandOne) * parseDouble(operandTwo);
                operator = null;
                operandOne = result + "";
                operandTwo = null;
                return;
            }
            case DIVIDE: {
                double result = parseDouble(operandOne) / parseDouble(operandTwo);
                operator = null;
                operandOne = result + "";
                operandTwo = null;
                return;
            }
            default:
        }
    }

    public void clearData() {
        operandOne = null;
        operandTwo = null;
        operator = null;
    }
}
