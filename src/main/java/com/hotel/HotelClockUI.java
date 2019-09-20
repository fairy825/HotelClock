package com.hotel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HotelClockUI {
    private static Hotel hotel;

    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到码农酒店");
        hotel = new Hotel(LocalDateTime.now());
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            showPhoneTime();
            lastOption = displayMenu(scanner);
        }
        System.out.println("再见\n");
    }

    public static void showPhoneTime(){
        System.out.println("现在手机时间：");
        //显示手机时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String pTime = formatter.format(hotel.getLocalDateTime());
        System.out.println(String.format("%s\n", pTime));
    }
    public static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("请选择");
        System.out.println("1.校准手机时间");
        System.out.println("2.查看城市时间");
        System.out.println("x.关机\n");
        String option = scanner.next();
        switch (option) {
            case "1":
                correctTime();
                return option;
            case "2":
                queryTime();
                return option;
            case "x":
                return option;
            default:
                System.out.println("输入无效,重新输入\n");
                return option;
        }

    }

    public static void correctTime(){
        hotel.changeTime();
        System.out.println("校准成功！\n");

    }

    public static void queryTime() throws Throwable {
        showPhoneTime();

        System.out.println("各地时间如下：");
        List<LobbyClock> clocks = new ArrayList<>();
        clocks.add(hotel.getBJClock());
        clocks.add(hotel.getLDClock());
        clocks.add(hotel.getMSClock());
        clocks.add(hotel.getSDClock());
        clocks.add(hotel.getNYClock());
        for(LobbyClock lc : clocks) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String lcTime = formatter.format(lc.getLocalDateTime());
            System.out.println(String.format("%s时间:%s", lc.getCity().getName(), lcTime));
        }
        System.out.println("请输入任意键后继续输入命令\n");
        System.in.read();

    }
}
