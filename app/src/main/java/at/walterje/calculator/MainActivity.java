package at.walterje.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText fieldDividend = (EditText) findViewById(R.id.inputDividend);
    private EditText fieldDivisor = (EditText) findViewById(R.id.inputDivisor);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set OnClickListener for the calculate button
        Button calcButton = (Button) findViewById(R.id.buttonCalculate);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    /** Calculate the result of both entered values
     * and print them on the screen.
     */
    private void calculateResult() {

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
        if (fieldDivisor.getText().toString().equals("0")) {
            return true;
        }
        return false;
    }

}
