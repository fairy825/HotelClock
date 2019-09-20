package com.hotel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel {
    private LocalDateTime localDateTime;

    private LobbyClock BJClock = new LobbyClock(City.Beijing);
    private LobbyClock LDClock = new LobbyClock(City.London);
    private LobbyClock MSClock = new LobbyClock(City.Moscow);
    private LobbyClock SDClock = new LobbyClock(City.Sydney);
    private LobbyClock NYClock = new LobbyClock(City.NewYork);

    public Hotel(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
    public void setBJClock(LobbyClock BJClock) {
        this.BJClock = BJClock;
    }
    public void setLDClock(LobbyClock LDClock) {
        this.LDClock = LDClock;
    }
    public void setSDClock(LobbyClock SDClock) {
        this.SDClock = SDClock;
    }
    public void setNYClock(LobbyClock NYClock) {
        this.NYClock = NYClock;
    }
    public void setMSClock(LobbyClock MSClock) {
        this.MSClock = MSClock;
    }
    public LobbyClock getSDClock() {
        return SDClock;
    }
    public LobbyClock getNYClock() {
        return NYClock;
    }
    public LobbyClock getBJClock() {
        return BJClock;
    }
    public LobbyClock getLDClock() {
        return LDClock;
    }
    public LobbyClock getMSClock() {
        return MSClock;
    }

    public void correctLobbyClocks() {
        setBJClock(new LobbyClock(City.Beijing));
        setLDClock(new LobbyClock(City.London));
        setSDClock(new LobbyClock(City.Sydney));
        setMSClock(new LobbyClock(City.Moscow));
        setNYClock(new LobbyClock(City.NewYork));
    }


    public void changeTime(){
        this.setLocalDateTime(LocalDateTime.now());
        correctLobbyClocks();
    }

}
