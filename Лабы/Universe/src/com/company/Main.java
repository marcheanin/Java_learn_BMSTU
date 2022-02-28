package com.company;

import java.util.Scanner;

public class Main {

    public static double averageWeight(Point[] universe, int n){
        double sum_mass = 0;
        for (int i = 0; i < n; i++) {
            sum_mass += universe[i].getMass();
        }
        return sum_mass / n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] universe = new Point[n];
        for(int i = 0; i < n; i++){
            double x = in.nextDouble();
            double y = in.nextDouble();
            double mass = in.nextDouble();
            universe[i] = new Point(x, y, mass);
        }
        double weight = averageWeight(universe, n);
        System.out.println(weight);
        in.close();
    }
}
