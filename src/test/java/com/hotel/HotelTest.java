package com.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class HotelTest {
    private Hotel h;
    private SimpleDateFormat dateFormat;
    @BeforeEach
    void init(){
        h = new Hotel(LocalDateTime.now());
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    @Test
    @DisplayName("修改手机时间")
    void changeHotelTime(){
//        Hotel h = new Hotel(LocalDateTime.now());
        h.changeTime();
        assertEquals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                h.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
    @Test
    @DisplayName("校准北京时钟的时间")
    void correctHotelBJLobbyClocks() {
//        Hotel h = new Hotel(LocalDateTime.now());
        h.correctLobbyClocks();
        Date d = new Date();
//        d.setTime(d.getTime()+8* 60 * 60 * 1000);
        assertEquals(d.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                h.getBJClock().getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "测试北京时间失败，现在纽约时间为"+dateFormat.format(d));
    }

    @Test
    @DisplayName("校准伦敦时钟的时间")
    void correctHotelLDLobbyClocks() {
//        Hotel h = new Hotel(LocalDateTime.now());
        h.correctLobbyClocks();
        Date d = new Date();
        d.setTime(d.getTime()-8* 60 * 60 * 1000);
        assertEquals(d.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                h.getLDClock().getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "测试伦敦时间失败，现在纽约时间为"+dateFormat.format(d));

    }

    @Test
    @DisplayName("校准莫斯科时钟的时间")
    void correctHotelMSLobbyClocks() {
//        Hotel h = new Hotel(LocalDateTime.now());
        h.correctLobbyClocks();
        Date d = new Date();
        d.setTime(d.getTime()-4* 60 * 60 * 1000);
        assertEquals(d.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                h.getMSClock().getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "测试莫斯科时间失败，现在纽约时间为"+dateFormat.format(d));

    }

    @Test
    @DisplayName("校准悉尼时钟的时间")
    void correctHotelSDLobbyClocks() {
//        Hotel h = new Hotel(LocalDateTime.now());
        h.correctLobbyClocks();
        Date d = new Date();
        d.setTime(d.getTime()+2* 60 * 60 * 1000);
        assertEquals(d.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                h.getSDClock().getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "测试悉尼时间失败，现在纽约时间为"+dateFormat.format(d));

    }

    @Test
    @DisplayName("校准纽约时钟的时间")
    void correctHotelNYLobbyClocks() {
//        Hotel h = new Hotel(LocalDateTime.now());
        h.correctLobbyClocks();
        Date d = new Date();
        d.setTime(d.getTime()-13* 60 * 60 * 1000);
        assertEquals(d.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                h.getNYClock().getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                "测试纽约时间失败，现在纽约时间为"+dateFormat.format(d)
        );

    }
}