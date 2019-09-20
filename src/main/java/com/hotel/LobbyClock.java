package com.hotel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LobbyClock {
    private City city;
    private int utc;
    private LocalDateTime localDateTime;

    public LobbyClock(City city) {
        this.city = city;
        Date d = DateUtil.getUTCTime();
        int myutc = 0;
        switch(city) {
            case Beijing:
                myutc = 8;
                break;
            case London:
                myutc = 0;
                break;
            case Moscow:
                myutc = 4;
                break;
            case Sydney:
                myutc = 10;
                break;
            case NewYork:
                myutc = -5;
        }
        this.utc = myutc;
        d.setTime(d.getTime()+myutc* 60 * 60 * 1000);

        this.localDateTime = d.toInstant()
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(int myutc) {
        this.localDateTime = localDateTime;
    }


}
