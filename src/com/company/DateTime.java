package com.company;

/**
 * Created by HP on 30/8/2017.
 */
public class DateTime {

    private String date;
    private String time;
    private String depature_time;
    private String depature_date;

    public DateTime(String date, String time) {
        this.setDate(date);
        this.setTime(time);
    }

    public String getDepature_time() {
        return depature_time;
    }

    public void setDepature_time(String depature_time) {
        this.depature_time = depature_time;
    }

    public String getDepature_date() {
        return depature_date;
    }

    public void setDepature_date(String depature_date) {
        this.depature_date = depature_date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
