package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 08/10/2019
 */

public class Time {
    Integer Hour;
    Integer Minute;
    String Time;
    int Comparator;

    public Time(Integer hour, Integer minute) {
        Hour = hour;
        Minute = minute;
        if (Minute<10)
        Time = hour+":0"+minute;
        else
        Time = hour+":"+minute;
        Comparator=Hour*60+Minute;
    }

    public Integer getHour() {
        return Hour;
    }

    public int getComparator(){
        return Comparator;
    }

    public void setHour(Integer hour) {
        Hour = hour;
    }

    public Integer getMinute() {
        return Minute;
    }

    public void setMinute(Integer minute) {
        Minute = minute;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
