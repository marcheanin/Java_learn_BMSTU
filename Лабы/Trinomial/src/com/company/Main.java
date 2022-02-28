package com.company;

import java.util.Arrays ;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        Trinomial[] polinoms = new Trinomial[n];
        for(int i = 0; i < n; i++){
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            polinoms[i] = new Trinomial(a, b, c);
        }
        Arrays.sort(polinoms);
        for (int i = 0; i < n; i++){
            System.out.println(polinoms[i]);
        }
        in.close();
    }
}
