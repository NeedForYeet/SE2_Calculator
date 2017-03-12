package at.walterje.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

    }
}
