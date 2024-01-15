package com.example.unitconvertionapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText numberEditText;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberEditText = findViewById(R.id.number);
        Button convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);
        convertButton.setOnClickListener(view -> convertKgToPounds());
    }

    @SuppressLint("StringFormatInvalid")
    private void convertKgToPounds() {
        String kgValueStr = numberEditText.getText().toString();

        if (!kgValueStr.isEmpty()) {
            try {
                double kgValue = Double.parseDouble(kgValueStr);
                double poundsValue = kgValue * 2.20462;
                @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String resultText;
                resultText = getString(R.string.value_in_pounds, poundsValue);
                resultTextView.setText(resultText);
            } catch (NumberFormatException e) {
                resultTextView.setText(R.string.invalid_input);
            }
        } else {
            resultTextView.setText(R.string.enter_value_to_convert);
        }
    }
}
