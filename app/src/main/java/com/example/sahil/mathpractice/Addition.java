package com.example.sahil.mathpractice;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Addition extends ActionBarActivity {

    private int userInput;
    private int firstNumber;
    private int secondNumber;
    private int correctAnswer;
    TextView number1;
    TextView number2;
    TextView plus;
    EditText userAnswer;
    Button submit;
    Button next;
    TextView result;
    Random rand;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        // Create a Random number generator.
        rand = new Random();

        // Initialize all of the GUI objects.
        number1 = (TextView) findViewById(R.id.numberOne);
        number2 = (TextView) findViewById(R.id.numberTwo);
        plus = (TextView) findViewById(R.id.plusSign);
        userAnswer = (EditText) findViewById(R.id.answer);
        submit = (Button) findViewById(R.id.submitButton);
        next = (Button) findViewById(R.id.nextButton);
        result = (TextView) findViewById(R.id.rightOrWrong);

        // Set the operation type.
        plus.setText("+");

        // Store random integers in the respective variables.
        firstNumber = rand.nextInt(100);
        secondNumber = rand.nextInt(100);

        // Calculate the correct answer.
        correctAnswer = firstNumber + secondNumber;

        // Display the numbers on the interface.
        number1.setText(String.format("%d", firstNumber));
        number2.setText(String.format("%d", secondNumber));

        // Create a listener for the answer.
        userAnswer.addTextChangedListener(userAnswerListener);

        // Create a listener for the "Next" button.
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Reset the stored strings.
                userAnswer.setText("");
                result.setText("");

                // Store random integers in the respective variables.
                firstNumber = rand.nextInt(100);
                secondNumber = rand.nextInt(100);

                // Calculate the correct answer.
                correctAnswer = firstNumber + secondNumber;

                // Display the numbers on the interface.
                number1.setText(String.format("%d", firstNumber));
                number2.setText(String.format("%d", secondNumber));
            }
        });
    }

    private TextWatcher userAnswerListener = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            userInput = Integer.parseInt(s.toString());

            // Create a listener for the button.
            submit.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitAnswer(userInput);
                }
            });
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void submitAnswer(int input) {
        if (input == correctAnswer) {
            result.setText("Correct!");
        }
        else {
            result.setText("Incorrect!");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
