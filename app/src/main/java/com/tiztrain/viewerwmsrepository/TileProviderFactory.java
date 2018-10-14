package com.tiztrain.viewerwmsrepository;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by tiztrain on 15-Jan-18.
 */

public class TileProviderFactory extends AppCompatActivity {
    static String WMSFormatString;
    public TextView tv;

    public int input = 0;

    public int getMeWMSID() {

        int result = AllWMSActivity.wmsID;
        return result;
    }

    public String getWMSFormatString() {
        input = getMeWMSID();

        if (input == 1) {
            this.WMSFormatString = "http://services.ga.gov.au/gis/services/Oil_Gas_Infrastructure/MapServer/WmsServer" +
                    "?service=WMS" +
                    "&version=1.3.0" +
                    "&request=GetMap" +
                    "&layers=National_Onshore_Gas_Pipelines" +
                    "&bbox=%f,%f,%f,%f" +
                    "&width=256" +
                    "&height=256" +
                    "&crs=EPSG:3857" +
                    "&format=image/png" +
                    "&transparent=true" +
                    "&styles=default";
        }
        if (input == 2) {
            this.WMSFormatString = "http://sedac.ciesin.columbia.edu/geoserver/wms" +
                    "?service=WMS" +
                    "&version=1.1.1" +
                    "&request=GetMap" +
                    "&layers=gpw-v3-population-density_2000" +
                    "&bbox=%f,%f,%f,%f" +
                    "&width=256" +
                    "&height=256" +
                    "&srs=EPSG:900913" +
                    "&format=image/png" +
                    "&transparent=true";
        }
        if (input == 3) {
            this.WMSFormatString = "http://services.ga.gov.au/site_7/services/Topographic_Base_Map_WM/MapServer/WmsServer" +
                    "?Service=wms" +
                    "&version=1.3.0" +
                    "&request=GetMap" +
                    "&layers=Railways_1" +
                    "&bbox=%f,%f,%f,%f" +
                    "&width=256" +
                    "&height=256" +
                    "&crs=EPSG:3857" +
                    "&format=image/png" +
                    "&transparent=true" +
                    "&styles=default";
        }
        return this.WMSFormatString;
    }


    public static WMSTileProvider getOsgeoWmsTileProvider() {
        TileProviderFactory myTPF = new TileProviderFactory();
        final String WMS_FORMAT_STRING = myTPF.getWMSFormatString();


        WMSTileProvider tileProvider = new WMSTileProvider(256, 256) {

            @Override
            public synchronized URL getTileUrl(int x, int y, int zoom) {
                double[] bbox = getBoundingBox(x, y, zoom);
                String s = String.format(Locale.US, WMS_FORMAT_STRING, bbox[MINX],
                        bbox[MINY], bbox[MAXX], bbox[MAXY]);
                Log.d("WMSDEMO", s);
                URL url = null;
                try {
                    url = new URL(s);
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
                return url;
            }
        };
        return tileProvider;
    }
}