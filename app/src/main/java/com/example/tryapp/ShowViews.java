package com.example.tryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowViews extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Best practice - use the same name as id - use meaningful names
    EditText myEditText;
    Button myButton;
    ImageButton PrevImageButton;
    ImageButton PlayImageButton;
    ImageButton NextImageButton;

    // Spinner element
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_views);

        // get the views
        myEditText = (EditText) findViewById(R.id.myEditText);
        myButton = (Button) findViewById(R.id.myButton);
        PrevImageButton = (ImageButton) findViewById(R.id.PrevImageButton);
        PlayImageButton = (ImageButton) findViewById(R.id.PlayImageButton);
        NextImageButton = (ImageButton) findViewById(R.id.NextImageButton);

        // install onClickListener for button
        /*
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = myEditText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
                msg.show();
            }
        });
        */

        mySpinner = (Spinner) findViewById(R.id.mySpinner);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Violet");
        categories.add("Indigo");
        categories.add("Blue");
        categories.add("Green");
        categories.add("Yellow");
        categories.add("Orange");
        categories.add("Red");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        mySpinner.setAdapter(dataAdapter);

        // Spinner click listener
        mySpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    // myButton:onClick() attribute
    public void myButtonOnClick(View view){
        String str = myEditText.getText().toString();
        Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
        msg.show();
    }

    // mediaButtons:onClick() attribute
    public void mediaButtonOnClick(View view){
        String str;
        switch (view.getId()) {
            case R.id.PrevImageButton:
                str = "previous song"; break;
            case R.id.PlayImageButton:
                str = "play song"; break;
            case R.id.NextImageButton:
                str = "next song"; break;
            default:
                str = "";
        }
        Toast msg = Toast.makeText(getBaseContext(), str,Toast.LENGTH_SHORT);
        msg.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}
