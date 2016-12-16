package com.test;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class
MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionTriggers.ActionType[] types = ActionTriggers.ActionType.getAllPublicActionTypes();

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (final ActionTriggers.ActionType type : types) {
            Button b = new Button(this);
            b.setText(ActionTriggers.ActionType.getDisplayName(type));
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("Action", type.name());
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });

            layout.addView(b);

        }

    }
}
