package com.location.locationtracker;

import java.util.Date;

public class LocationDetails {
    private Date year;
    private Date month;
    private Date date;
    private Date hour;
    private Date minute;
    private Date second;
  private double Longitude;
  private double Latitude;
  private Date datetime;

    public LocationDetails(Date year, Date month, Date date, Date hour, Date minute, Date second, double longitude, double latitude) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        Longitude = longitude;
        Latitude = latitude;
    }

    public LocationDetails(double longitude, double latitude, Date datetime) {
        Longitude = longitude;
        Latitude = latitude;
        this.datetime = datetime;
    }



    public LocationDetails(double longitude, double latitude) {
        Longitude = longitude;
        Latitude = latitude;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Date getMinute() {
        return minute;
    }

    public void setMinute(Date minute) {
        this.minute = minute;
    }

    public Date getSecond() {
        return second;
    }

    public void setSecond(Date second) {
        this.second = second;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
