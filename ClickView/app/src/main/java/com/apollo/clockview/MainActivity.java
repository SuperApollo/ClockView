package com.apollo.clockview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final ClockView clockView = (ClockView) findViewById(R.id.clock_view);
        clockView.startTime();
        final EditText et_hour = (EditText) findViewById(R.id.et_hour);
        final EditText et_minute = (EditText) findViewById(R.id.et_minute);
        final EditText et_second = (EditText) findViewById(R.id.et_second);
        Button btn_set = (Button) findViewById(R.id.btn_set);
        Button btn_now = (Button) findViewById(R.id.btn_now);

        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_h = et_hour.getText().toString().trim();
                String s_m = et_minute.getText().toString().trim();
                String s_s = et_second.getText().toString().trim();
                if (TextUtils.isEmpty(s_h) || TextUtils.isEmpty(s_m) || TextUtils.isEmpty(s_s)) {
                    Toast.makeText(getApplicationContext(), "请输入合法的时间!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int hour = Integer.valueOf(s_h);
                int minute = Integer.valueOf(s_m);
                int second = Integer.valueOf(s_s);
                clockView.setTime(hour, minute, second);
            }
        });

        btn_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clockView.getCurrentTime();
            }
        });


    }
}
