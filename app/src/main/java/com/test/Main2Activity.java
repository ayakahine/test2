package com.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;



public class Main2Activity extends Activity {

    private SharedPreferences prefs;
    private String prefName = "spinner_value2";
    int id = 0;

    Button IM1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if(getIntent().getBooleanExtra("Exit me",false)) {
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
        IM1 = (Button)findViewById(R.id.closeButton);
        final List<String> list = new ArrayList<String>();
        list.add("Double tap on the back of the phone");
        list.add("Tap on the back of the phone");
        list.add("Tap on the phone on its side");

        IM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(
                        Main2Activity.this);
                builder.setTitle("Exit Application");
                builder.setMessage("Are you sure you want to exit?:(");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("Exit me", true);
                                startActivity(intent);
                                finish();


                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {


                            }
                        });
                builder.show();
            }
        });


        final Spinner sp = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp);

        prefs = getSharedPreferences(prefName,0);
        id = prefs.getInt("last_val", 0);
        sp.setSelection(id);

        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int pos, long arg3) {
                // TODO Auto-generated method stub

                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putInt("last_val", pos);

                //---saves the values---
                editor.commit();

                Toast.makeText(getBaseContext(), sp.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }


}