package com.location.locationtracker;

import android.content.Intent;

import java.util.Date;

public class LocationDetails {
    private String name;
  private double Longitude;
  private double Latitude;
//  private String datetime;


    public LocationDetails() {
    }

    public LocationDetails(String name, double longitude, double latitude) {
        this.name = name;
        Longitude = longitude;
        Latitude = latitude;
    }

    public LocationDetails(String name, double longitude, double latitude, Date datetime) {
        this.name = name;
        Longitude = longitude;
        Latitude = latitude;
      //  this.datetime = datetime;
    }

    public LocationDetails(double longitude, double latitude, Date datetime) {
        Longitude = longitude;
        Latitude = latitude;
       // this.datetime = datetime;
    }

   /* public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
*/
    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toStrings(){
        return name+" "+String.valueOf(Latitude)+" "+String.valueOf(Longitude);
    }
}
