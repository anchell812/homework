package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VasyasProgram {
    public static final String DATE_FORMATTER = "dd.MM.yyyy";

    public static LocalDateTime today = LocalDateTime.now();

    public LocalDate enterDate() {
        System.out.println("Enter date in dd.MM.yyyy format:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String date = scanner.nextLine();
            if (date.isEmpty()) {
                continue;
            }

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                LocalDate date1 = LocalDate.parse(date, formatter);
                return date1;

            } catch (Exception ex) {
                System.out.println("Invalid date format");
                return enterDate();
            }
        }
        System.out.println("Please enter date.");
        return enterDate();
    }

    public void checkIfDateFuture(LocalDateTime day) {
        if (today.isBefore(day)){
            throw new IllegalArgumentException("Передана дата из будущего. " + day);
        }
    }

    public String getDuration(LocalDateTime day) {

        Duration duration = Duration.between(day, LocalDateTime.now());
        LocalDateTime today = LocalDateTime.now();
        int currentMonth = today.getMonthValue();
        LocalDateTime nextWaterDate;

        if (currentMonth == 12 | currentMonth == 1 | currentMonth == 2) {
            nextWaterDate = day.plusDays(30);
            if (duration.toDays() > 30) {
                return "Срочно поливай, это нужно было сделать еще " + nextWaterDate;
            } else {
                return "Поливать не нужно, дата полива: " + nextWaterDate;
            }
        }
        if (currentMonth == 3 | currentMonth == 4 | currentMonth == 5 | currentMonth == 9 | currentMonth == 10 | currentMonth == 11) {
            nextWaterDate = day.plusDays(7);
            if (duration.toDays() > 7) {
                //System.out.println("Поливать");
                return "Срочно поливай, это нужно было сделать еще " + nextWaterDate;
            } else {
                //System.out.println("Поливать не нужно");
                return "Поливать не нужно, дата полива: " + nextWaterDate;
            }
        }
        else {

            Sensor sensor = new Sensor();

            if (sensor.getTodayHumidity() > 30) {
                return "Поливать не нужно, проверить влажность завтра";
            } else {
                return "Нужно полить сегодня";
            }
        }
    }


    public LocalDateTime convertToLocalDateTime(LocalDate lastWaterDate) {
        return lastWaterDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}
