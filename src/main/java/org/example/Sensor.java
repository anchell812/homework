package org.example;

public class Sensor {

    public double humidity;

    public double getTodayHumidity() {
        humidity = (int) Math.floor(Math.random() * 100);
        System.out.println("Влажность воздуха сегодня: " + humidity);
        return humidity;
    }
}


