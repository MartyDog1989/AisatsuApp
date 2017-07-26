package jp.techacademy.matsuyama.akihiro.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    int h;
    int m;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textView = (TextView)findViewById(R.id.textView);
                if((h >= 18 && h <= 25) && (m >= 0 && m <= 59) || (h == 0 || h == 1) && (m >= 0 && m <= 59)) {
                    textView.setText("こんばんは");
                }
                else if((h >= 2 && h <= 9) && (m >= 0 && m <= 59)) {
                    textView.setText("おはよう");
                }
                else if((h >= 10 && h <= 17) && (m >= 0 && m <= 59)) {
                    textView.setText("こんにちは");
                }

            }
        });
        Button button2 = (Button)findViewById(R.id.timePickerDialog);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    private void showTimePickerDialog() {
        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h = hourOfDay;
                m = minute;
            }
        }, 13, 0, true);
        tpd.show();
    }
}
