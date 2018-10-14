package com.tiztrain.viewerwmsrepository;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AllWMSActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnSearchWMS, btnWMSOverMap;
    public TextView tv;
    public int input;

    public static Context contextOfApplication;
    public static int wmsID;


    //Launches this method when activity is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_wms);
        //Creates the toolbar at the top of the page
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creates the action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "EXPORTING FUNCTIONALITY TO BE RELEASED IN FUTURE DESIGN", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set database to a variable
        myDb = new DatabaseHelper(this);

        //tv.addTextChangedListener(textWatcher);

        init();

        contextOfApplication = getApplicationContext();


    }

    public static Context getContextOfApplication(){
        return contextOfApplication;
    }

    public void init(){
        btnSearchWMS = (Button)findViewById(R.id.button_WMSSearch);
        btnWMSOverMap = findViewById(R.id.btn_WMSOverMap);
        btnWMSOverMap.setEnabled(false);
        //btnSetWMS = findViewById(R.id.btnSetWMS);

        //Creates the listener for the clicking on the search WMS button
        btnSearchWMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sets all data stored in the database to the variable
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0){
                    //Uses the show message function to display a message temporarily
                    //if no data is found in database
                    showMessage("Error", "No data found");
                    return;
                }

                //Creates an empty string
                StringBuffer buffer = new StringBuffer();
                //Attaches the items in the res variable to the buffer string
                while (res.moveToNext()){
                    buffer.append("ID Number: " + res.getString(0) + "\t\t\t" +
                            "WMS Title: " + res.getString(1) + "\n");
                }
                //Sets the buffer string to the textview
                tv = (TextView)findViewById(R.id.scroll_field);
                tv.setText(buffer.toString());
            }
        });

        //Sets button listener to open activity
        btnWMSOverMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openWMSOverMap = new Intent(AllWMSActivity.this, MapViewerActivity.class);
                int input, viewID;

                input = getWMSID();
                ////Log.d("check", input);
                viewID = myDb.listWMS(input);


                if (input == viewID){
                    startActivity(openWMSOverMap);
                    wmsID = getWMSID();
                }
                else{
                    showMessage("Error", "ID number does not match " +
                            "any entries in the database.");
                }
            }
        });

        //TextWatcher button on enables if there is text in TextView
        tv = findViewById(R.id.tvIDInput);
        tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    btnWMSOverMap.setEnabled(false);
                } else {
                    btnWMSOverMap.setEnabled(true);
                }
            }
        });
    }

    //Gets the user input at ID selection
    public int getWMSID(){
        int input;
        tv = findViewById(R.id.tvIDInput);
        input = Integer.valueOf(tv.getText().toString());
        Log.d("getWMSID","getWMSID = " + input);
        return input;
    }


    //Shows message popup
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    //Not needed
//    private void checkFieldsForEmptyValues(){
//        Button b = findViewById(R.id.btn_WMSOverMap);
//
//        String s1 = tv.getText().toString();
//
//        if(s1.equals("")){
//            b.setEnabled(false);
//        }
//        else
//        {
//            b.setEnabled(true);
//        }
//    }
}
