package com.tiztrain.viewerwmsrepository;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by tiztrain on 24-Jan-18.
 */

public class WMS implements Serializable{

    public int id;
    public String titleWMS;
    public String urlWMS;
    public String serviceTypeWMS;
    public String versionTypeWMS;
    public String requestTypeWMS;
    public String layerWMS;
    public String bboxWMS;
    public String widthWMS;
    public String heightWMS;
    public String projectionWMS;
    public String imgFormatWMS;
    public String transparentWMS;
    public String stylesWMS;
    
    public WMS(){
        super();
    }
    
    public WMS(int id, String titleWMS ,String urlWMS ,String serviceTypeWMS ,String versionTypeWMS ,
               String requestTypeWMS ,String layerWMS ,String bboxWMS ,String widthWMS ,
               String heightWMS ,String projectionWMS ,String imgFormatWMS ,String transparentWMS ,
               String stylesWMS){
        super();
        this.id = id;
        this.titleWMS = titleWMS;
        this.urlWMS = urlWMS;
        this.serviceTypeWMS = serviceTypeWMS;
        this.versionTypeWMS = versionTypeWMS;
        this.requestTypeWMS = requestTypeWMS;
        this.layerWMS = layerWMS;
        this.bboxWMS = bboxWMS;
        this.widthWMS = widthWMS;
        this.heightWMS = heightWMS;
        this.projectionWMS = projectionWMS;
        this.imgFormatWMS = imgFormatWMS;
        this.transparentWMS = transparentWMS;
        this.stylesWMS = stylesWMS;
    }

    //Doesn't work correctly
//    public void sendArrayWMSs() {
//        ArrayList<WMS> WMSs = new ArrayList<WMS>();
//        Intent intent2 = new Intent(WMS.this, MainActivity.class);
//
//        WMS wms1 = new WMS(1, "AUS Oil and Gas Pipelines", "http://services.ga.gov.au/gis/services/Oil_Gas_Infrastructure/MapServer/WmsServer", "?service=WMS", "&version=1.3.0", "&request=GetMap", "&layers=National_Onshore_Gas_Pipelines", "&bbox=%f,%f,%f,%f", "&width=256", "&height=256", "&crs=EPSG:3857", "&format=image/png", "&transparent=true", "&styles=default");
//        WMS wms2 = new WMS(2, "WW Population Densities - 2000", "http://sedac.ciesin.columbia.edu/geoserver/wms", "?service=WMS", "&version=1.1.1", "&request=GetMap", "&layers=gpw-v3-population-density_2000", "&bbox=%f,%f,%f,%f", "&width=256", "&height=256", "&srs=EPSG:900913", "&format=image/png", "&transparent=true", "");
//
//        WMSs.add(wms1);
//        WMSs.add(wms2);
//
//        intent2.putExtra("list", WMSs);
//        //Log.d("WMSLIST", "What is in " + WMSs);
//        //startActivity(intent2);
//    }

    //Trying to replace PARCLEABLE with SERIALIZATION
//    public WMS(Parcel in) {
//        id = in.readInt();
//        titleWMS = in.readString();
//        urlWMS = in.readString();
//        serviceTypeWMS = in.readString();
//        versionTypeWMS = in.readString();
//        requestTypeWMS = in.readString();
//        layerWMS = in.readString();
//        bboxWMS = in.readString();
//        widthWMS = in.readString();
//        heightWMS = in.readString();
//        projectionWMS = in.readString();
//        imgFormatWMS = in.readString();
//        transparentWMS = in.readString();
//        stylesWMS = in.readString();
//    }




//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(this.id);
//        dest.writeString(this.titleWMS);
//        dest.writeString(this.urlWMS);
//        dest.writeString(this.serviceTypeWMS);
//        dest.writeString(this.versionTypeWMS);
//        dest.writeString(this.requestTypeWMS);
//        dest.writeString(this.layerWMS);
//        dest.writeString(this.bboxWMS);
//        dest.writeString(this.widthWMS);
//        dest.writeString(this.heightWMS);
//        dest.writeString(this.projectionWMS);
//        dest.writeString(this.imgFormatWMS);
//        dest.writeString(this.transparentWMS);
//        dest.writeString(this.stylesWMS);
//    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }

//    public static final Creator<WMS> CREATOR = new Creator<WMS>() {
//        @Override
//        public WMS createFromParcel(Parcel in) {
//            return new WMS(in);
//        }
//
//        @Override
//        public WMS[] newArray(int size) {
//            return new WMS[size];
//        }
//    };

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getTitleWMS(){
        return titleWMS;
    }
    
    public void setTitleWMS(String titleWMS){
        this.titleWMS = titleWMS;
    }

    public String getUrlWMS() {
        return urlWMS;
    }

    public void setUrlWMS(String urlWMS){
        this.urlWMS = urlWMS;
    }

    public String getServiceTypeWMS() {
        return serviceTypeWMS;
    }

    public void setServiceTypeWMS(String serviceTypeWMS){
        this.serviceTypeWMS = serviceTypeWMS;
    }

    public String getVersionTypeWMS() {
        return versionTypeWMS;
    }

    public void setVersionTypeWMS(String versionTypeWMS){
        this.versionTypeWMS = versionTypeWMS;
    }

    public String getRequestTypeWMS() {
        return requestTypeWMS;
    }

    public void setRequestTypeWMS(String requestTypeWMS) {
        this.requestTypeWMS = requestTypeWMS;
    }

    public String getLayerWMS() {
        return layerWMS;
    }

    public void setLayerWMS(String layerWMS) {
        this.layerWMS = layerWMS;
    }

    public String getBboxWMS() {
        return bboxWMS;
    }

    public void setBboxWMS(String bboxWMS) {
        this.bboxWMS = bboxWMS;
    }

    public String getWidthWMS() {
        return widthWMS;
    }

    public void setWidthWMS(String widthWMS) {
        this.widthWMS = widthWMS;
    }

    public String getHeightWMS() {
        return heightWMS;
    }

    public void setHeightWMS(String heightWMS) {
        this.heightWMS = heightWMS;
    }

    public String getProjectionWMS() {
        return projectionWMS;
    }

    public void setProjectionWMS(String projectionWMS) {
        this.projectionWMS = projectionWMS;
    }

    public String getImgFormatWMS() {
        return imgFormatWMS;
    }

    public void setImgFormatWMS(String imgFormatWMS) {
        this.imgFormatWMS = imgFormatWMS;
    }

    public String getTransparentWMS() {
        return transparentWMS;
    }

    public void setTransparentWMS(String transparentWMS) {
        this.transparentWMS = transparentWMS;
    }

    public String getStylesWMS() {
        return stylesWMS;
    }

    public void setStylesWMS(String stylesWMS) {
        this.stylesWMS = stylesWMS;
    }

    public String getWMSFormatString(){
        return urlWMS + serviceTypeWMS + versionTypeWMS + requestTypeWMS + layerWMS + bboxWMS +
                widthWMS + heightWMS + projectionWMS + imgFormatWMS + transparentWMS + stylesWMS;
    }
}


