package org.example;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //задание 1
        CheckFence inscription = new CheckFence();
        Scanner lengthFromUser = new Scanner(System.in);
        System.out.println("Введи длину забора в метрах: ");
        double number = lengthFromUser.nextDouble();
        System.out.println(inscription.checkFenceForInscription(number));

        //задание 2
        VasyasProgram program = new VasyasProgram();
        LocalDate enteredDay = program.enterDate();
        LocalDateTime day = program.convertToLocalDateTime(enteredDay);
        program.checkIfDateFuture(day);
        System.out.println(program.getDuration(day));

    }
}