package com.example.oga.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ボタン
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        // テキスト
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText("テキスト");

    }

    @Override
    public void onClick(View v) {

        // TimePickerを呼び出す
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        // TimePickerの時間によってテキストを書き換える
                        if(2 <= hourOfDay && hourOfDay < 10) {
                            mTextView.setText("おはよう");
                        } else if(10 <= hourOfDay && hourOfDay < 18) {
                            mTextView.setText("こんにちは");
                        } else {
                            mTextView.setText("こんばんは");
                        }

                    }
                },
                0, // 初期値（時間）
                0,  // 初期値（分）
                true);

        timePickerDialog.show();
    }

}
