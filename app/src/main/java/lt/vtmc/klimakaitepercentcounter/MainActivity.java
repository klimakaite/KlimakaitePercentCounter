package lt.vtmc.klimakaitepercentcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enterAmount;
    private SeekBar seekBar_percent;
    private TextView textView_percent;
    private TextView tip;
    private TextView total;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = findViewById(R.id.enterAmount);
        seekBar_percent = findViewById(R.id.seekBar_percent);
        textView_percent = findViewById(R.id.textView_percent);
        tip = findViewById(R.id.tip);
        total = findViewById(R.id.total);
        result = findViewById(R.id.result);

        seekBar_percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int i;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i = progress;
                textView_percent.setText(i + "%");
                results();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        enterAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                results();
            }
        });
    }

    public void results(){
        double amount0 = Double.parseDouble(enterAmount.getText().toString());
        double amount = Math.round(amount0 * 100.0) / 100.0;
        int percent = seekBar_percent.getProgress();
        double tip3 = amount * percent / 100.0;
        double tip2 = Math.round(tip3 * 100.0) / 100.0;
        tip.setText(String.valueOf(tip2));
        double total3 = amount - tip2;
        double total2 = Math.round(total3 * 100.0) / 100.0;
        total.setText(String.valueOf(total2));
        result.setText("Amount: "+String.valueOf(amount) + "\nTip: " + String.valueOf(tip2) + "\nTotal: " + String.valueOf(total2) + "\n");
    }

}