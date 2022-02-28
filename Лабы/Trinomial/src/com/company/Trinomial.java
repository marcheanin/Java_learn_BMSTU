package com.company;

public class Trinomial implements Comparable <Trinomial>{
    private double a;
    private double b;
    private double c;

    public Trinomial(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getSumRoots(){
        return -this.b / this.a;
    }

    public int compareTo(Trinomial obj) {
        if (getSumRoots() < obj.getSumRoots()) return -1;
        if (getSumRoots()  ==  obj.getSumRoots()) return 0;
        return 1;
    }

    public String toString(){
        return "coefficients: " + this.a + " " + this.b + " " + this.c + " sum roots: " + getSumRoots();
    }
}
