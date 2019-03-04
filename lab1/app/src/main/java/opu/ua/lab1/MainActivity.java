package opu.ua.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText leftField;
    EditText rightField;
    TextView resultField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        leftField = findViewById(R.id.editText3);
        rightField = findViewById(R.id.editText4);
        resultField = findViewById(R.id.textView2);

        findViewById(R.id.button).setOnClickListener(this::handleClick);
        findViewById(R.id.button2).setOnClickListener(this::handleClick);
    }

    public void handleClick(View view) {
        String buttonActionText = ((Button) view).getText().toString();
        if (leftField.getText().toString().isEmpty() || rightField.getText().toString().isEmpty()) {
            resultField.setText("Empty field(s)");
            return;
        }


        switch (buttonActionText) {
            case "*": {
                resultField.setText(new Double(Double.parseDouble(leftField.getText().toString()) * Double.parseDouble(rightField.getText().toString())).toString());
            }
            break;
            case "/": {
                if (Double.parseDouble(rightField.getText().toString()) == 0) {
                    resultField.setText("Division by zero");
                    return;
                }

                resultField.setText(new Double(Double.parseDouble(leftField.getText().toString()) / Double.parseDouble(rightField.getText().toString())).toString());
            }
            break;
            case "-": {
                resultField.setText(new Double(Double.parseDouble(leftField.getText().toString()) - Double.parseDouble(rightField.getText().toString())).toString());
            }
            break;
            case "+": {
                resultField.setText(new Double(Double.parseDouble(leftField.getText().toString()) + Double.parseDouble(rightField.getText().toString())).toString());
            }
            break;
        }
    }
}
