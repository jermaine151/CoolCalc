package org.jermaine151.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    TextView resultsView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Double result = 0.0;
    Double cleanedUpResult = 0.0;

    Operation currentOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = (ImageButton)findViewById(R.id.subtractBtn);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);
        resultsView = (TextView)findViewById(R.id.resultsView);

        resultsView.setText("0");

            oneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(1);
                }
            });

            twoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(2);
                }
            });

            threeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(3);
                }
            });

            fourBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(4);
                }
            });

            fiveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(5);
                }
            });

            sixBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(6);
                }
            });

            sevenBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(7);
                }
            });

            eightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(8);
                }
            });

            nineBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(9);
                }
            });

            zeroBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberPressed(0);
                }
            });

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processOperation(Operation.ADD);
                }
            });

            subtractBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processOperation(Operation.SUBTRACT);
                }
            });

            multiplyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processOperation(Operation.MULTIPLY);
                }
            });

            divideBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processOperation(Operation.DIVIDE);
                }
            });

            calcBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processOperation(Operation.EQUAL);
                }
            });

            clearBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    leftValueStr = "";
                    rightValueStr = "";
                    runningNumber = "";
                    resultsView.setText("0");
                    currentOperation = null;
                    result = 0.0;
                }
            });
    }
        void processOperation(Operation operation) {
            if (currentOperation != null) {

                if (runningNumber != "") {
                    rightValueStr = runningNumber;
                    runningNumber = "";

                    switch (currentOperation) {
                        case ADD:
                            result = Double.parseDouble(leftValueStr) + Double.parseDouble(rightValueStr);
                            break;
                        case SUBTRACT:
                            result = Double.parseDouble(leftValueStr) - Double.parseDouble(rightValueStr);
                            break;
                        case MULTIPLY:
                            result = Double.parseDouble(leftValueStr) * Double.parseDouble(rightValueStr);
                            break;
                        case DIVIDE:
                            result = Double.parseDouble(leftValueStr) / Double.parseDouble(rightValueStr);
                            break;
                    }
                    runningNumber = "";
                    leftValueStr = String.valueOf(result);
                    resultsView.setText(leftValueStr.replaceAll("\\.0+$",""));
                }
            } else {
                if (runningNumber != "") {
                    leftValueStr = runningNumber;
                    runningNumber = "";
                }
            }
            currentOperation = operation;
        }

        void numberPressed(int number) {
            runningNumber += String.valueOf(number);
            resultsView.setText(runningNumber);

        }
}
