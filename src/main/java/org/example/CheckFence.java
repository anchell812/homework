package org.example;

public class CheckFence {

    private int threeLetters = 62;
    private int space = 12;


    public double inscriptionLenght() {
        return (space * 3) + (threeLetters * 5);
    }

    public boolean checkFenceForInscription(double fenceLength) {
        double fenceLengthInCm = fenceLength * 100;
        if (fenceLengthInCm > this.inscriptionLenght()) {
            return true;
        } else return false;
    }
}
