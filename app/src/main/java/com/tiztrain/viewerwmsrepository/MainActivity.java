//package com.viewerwms.tiztrain.viewerwmsrepository;
package com.tiztrain.viewerwmsrepository;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creates the instance of the database to be used for the app
    DatabaseHelper myDb;

    private TextView mTextMessage;
    public Button butt_ViewAllWMS;

    // Creates the buttons for navigation around the application
    public void init(){

        butt_ViewAllWMS = (Button)findViewById(R.id.button_ViewAllWMS);

        butt_ViewAllWMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAllWMS = new Intent(MainActivity.this, AllWMSActivity.class);
                startActivity(openAllWMS);
            }
        }
        );
        //FUNCTION DOESN"T WORK
        //sendArrayWMSs();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
//                case R.id.navigation_export_dataset:
//                    mTextMessage.setText(R.string.title_export_dataset);
//                    return true;
                case R.id.navigation_about:
                    mTextMessage.setText(R.string.title_about);
                    return true;
            }
            return false;
        }
    };

    // Runs when the app is opened.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        init();

        myDb = new DatabaseHelper(this);
        //Clears the database if needed
//        myDb.clearDatabase(myDb.TABLE_NAME);
        //Deletes the database if needed
        myDb.deleteDatabase(myDb.TABLE_NAME);

        ArrayList<WMS> listWMS;
        listWMS = arrayWMSs();

        if (listWMS != null){
            for (int i = 0; i<listWMS.size(); i++){
                int id = listWMS.get(i).getID();
                String title = listWMS.get(i).getTitleWMS();
                String compUrlWMS = listWMS.get(i).getWMSFormatString();
                //Log.d("id","id is " + listWMS.get(i).getID());
                //Log.d("title","title is " + listWMS.get(i).getTitleWMS());
                //Log.d("url","url is " + listWMS.get(i).getWMSFormatString());
                myDb.insertData(id, title, compUrlWMS);
            }
        }
        else{
            //Log.d("WMSnull","WMS list is null");
        }

    }

    public ArrayList<WMS> arrayWMSs(){

        WMS wms1 = new WMS(1,"AUS Oil and Gas Pipelines", "http://services.ga.gov.au/gis/services/Oil_Gas_Infrastructure/MapServer/WmsServer", "?service=WMS", "&version=1.3.0", "&request=GetMap", "&layers=National_Onshore_Gas_Pipelines", "&bbox=%f,%f,%f,%f", "&width=256", "&height=256", "&crs=EPSG:3857", "&format=image/png", "&transparent=true", "&styles=default");
        WMS wms2 = new WMS(2,"WW Population Densities - 2000", "http://sedac.ciesin.columbia.edu/geoserver/wms", "?service=WMS", "&version=1.1.1", "&request=GetMap", "&layers=gpw-v3-population-density_2000", "&bbox=%f,%f,%f,%f", "&width=256", "&height=256", "&srs=EPSG:900913", "&format=image/png", "&transparent=true", "");
        WMS wms3 = new WMS(3,"Railways", "http://http://services.ga.gov.au/site_7/services/Topographic_Base_Map_WM/MapServer/WmsServer", "?service=WMS", "&version=1.3.0", "&request=GetMap", "&layers=Railways_1", "&bbox=%f,%f,%f,%f", "&width=256", "&height=256", "&srs=EPSG:3857", "&format=image/png", "&transparent=true", "&styles=default");


        ArrayList <WMS> WMSs = new ArrayList<WMS>();
        WMSs.add(wms1);
        WMSs.add(wms2);
        WMSs.add(wms3);
        return (WMSs);
    }



}
