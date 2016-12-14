package com.test;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class
MainActivity extends Activity {
    public Button lampButton,alarmButton,muteButton;

    public void LightButtonClick() {
        lampButton = (Button) findViewById(R.id.lampButton);
        lampButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MainActivity.this,Main1Activity.class);
                startActivity(toy);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    public void AlarmButtonClick() {
        alarmButton = (Button) findViewById(R.id.alarmButton);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(toy);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    public void MuteButtonClick() {
        muteButton = (Button) findViewById(R.id.muteButton);
        muteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().getBooleanExtra("Exit me",false)) {
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
        AlarmButtonClick();
        MuteButtonClick();
        LightButtonClick();
    }
}
