package at.walterje.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText fieldDividend;
    EditText fieldDivisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set OnClickListener for the calculate button
        Button calcButton = (Button) findViewById(R.id.buttonCalculate);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFieldErrors();
                calculateResult();
            }
        });

        fieldDividend = (EditText) findViewById(R.id.inputDividend);
        fieldDivisor = (EditText) findViewById(R.id.inputDivisor);
    }

    /**
     * Calculate the result of both entered values
     * and print them on the screen.
     */
    private void calculateResult() {

        // check for errors before trying to parse the input to double
        if (checkForInputErrors()) {
            return;
        }

        // get the actual double values from the user input
        double dividend = Double.parseDouble(fieldDividend.getText().toString());
        double divisor = Double.parseDouble(fieldDivisor.getText().toString());

        // take Double instead of regular double for .toString() in setText()
        Double result = dividend / divisor;

        // show the result onscreen
        TextView outputResult = (TextView) findViewById(R.id.textResult);
        outputResult.setText(result.toString());
    }

    /**
     * Checks for errors in user input, e.g. divide by zero
     * @return true if errors occured
     */
    private boolean checkForInputErrors() {
        String inputDivisor = fieldDivisor.getText().toString();
        String inputDividend = fieldDividend.getText().toString();

        boolean hasError = false;

        // check for divide by zero
        if (inputDivisor.equals("0")) {
            setErrorMessage(fieldDivisor, getString(R.string.string_div_zero));
            fieldDivisor.requestFocus();
            hasError = true;
        }

        // check for input starting with '.', '-', is empty, or "-."
        if (inputDividend.startsWith(".") || inputDividend.isEmpty()
                || inputDividend.equals("-") || inputDividend.startsWith("-.")) {
            setErrorMessage(fieldDividend, getString(R.string.string_malformed_input));
            fieldDividend.requestFocus();
            hasError = true;
        }
        if (inputDivisor.startsWith(".") || inputDivisor.isEmpty()
                || inputDivisor.equals("-") || inputDivisor.startsWith("-.")) {
            setErrorMessage(fieldDivisor, getString(R.string.string_malformed_input));
            fieldDivisor.requestFocus();
            hasError = true;
        }
        return hasError;
    }

    /**
     * Sets an error message on a given field.
     * @param textField Field to show the error message at
     * @param errorMessage Error message to show
     */
    private void setErrorMessage(EditText textField, String errorMessage) {
        textField.setError(errorMessage);
    }

    /**
     * Clears the errors for both fields
     * Somewhat unnecessary as of now.
     */
    private void clearFieldErrors() {
        fieldDividend.setError(null);
        fieldDivisor.setError(null);
    }

}