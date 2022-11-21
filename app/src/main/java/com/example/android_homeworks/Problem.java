package com.example.android_homeworks;

public class Problem {
    private double result;

    public int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public double getResult() {
        return result;
    }

    public String getProblem() {
        int a = getRandom(-100, 250);
        int b = getRandom(-100, 275);
        String sign = getRandomSign();
        if (sign.equals("+"))
            result = a + b;
        if (sign.equals("-"))
            result = a - b;
        if (sign.equals("*"))
            result = a * b;
        if (sign.equals(":")){
            if (b == 0){
                while (b == 0){
                    b = getRandom(1, 275);
                }
            }
            result = (double) a / (double) b;
        }
        return a + " " + sign + " " + b + " ?";

    }
    public double getNoiseResult(){
        int gr = getRandom(-10, 20);
        while(gr == 0){
            gr = getRandom(-10, 20);
        }
        return result + (double) gr;
    }
    private String getRandomSign() {
        int c = getRandom(1, 15);
        if (c >= 1 && c < 4) {
            return "+";
        }
        if (c >= 4 && c < 7) {
            return "-";
        }
        if (c >= 7 && c < 12) {
            return "*";
        }
        if (c >= 12 && c <= 15) {
            return ":";
        }
        return "+";
    }

}
