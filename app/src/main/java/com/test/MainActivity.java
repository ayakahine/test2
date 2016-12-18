package com.test;

import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class
MainActivity extends Activity {
    private String gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionTriggers.ActionType[] types = ActionTriggers.ActionType.getAllPublicActionTypes();

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (final ActionTriggers.ActionType type : types) {

            Integer picture = ActionTriggers.ActionType.getPictures(type);
            Button b = new Button(this);
            b.setCompoundDrawablesWithIntrinsicBounds(picture,0,0,0);
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

            gesture = getIntent().getStringExtra("Gesture");


            TextView t = new TextView(MainActivity.this);
            t.setText(gesture + " gesture is connected to " + ActionTriggers.ActionType.getDisplayName(type));
            layout.addView(t);

        }

    }
}
