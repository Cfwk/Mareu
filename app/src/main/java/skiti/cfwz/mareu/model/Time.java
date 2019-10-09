package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 08/10/2019
 */

public class Time {
    Integer Hour;
    Integer Minute;
    String Time;


    public Time(Integer hour, Integer minute) {
        Hour = hour;
        Minute = minute;
        Time = hour+":"+minute;
    }

    public Integer getHour() {
        return Hour;
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
