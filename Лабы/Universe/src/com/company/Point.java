package com.company;

public class Point {
    private double x;
    private double y;
    private double mass;

    public Point(double x, double y, double mass){
        this.x = x;
        this.y = y;
        this.mass = mass;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){ return this.y; }
    public double getMass(){ return this.mass; }

    public String toString(){
        return "cords: (" + this.x + ", " + this.y + ") mass: " + this.mass;
    }
}
