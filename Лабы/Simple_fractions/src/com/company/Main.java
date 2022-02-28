package com.company;

public class Main {

    public static int myGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static simpleFraction fractionPlus(simpleFraction A, simpleFraction B){
        int a1 = A.getX(), a2 = A.getY();
        int b1 = B.getX(), b2 = B.getY();
        int y = (a2 * b2) / myGcd(a2, b2);
        a1 *= y / a2;
        b1 *= y / b2;
        int x = a1 + b1;
        return new simpleFraction(x, y);
    }

    public static simpleFraction fractionMul(simpleFraction A, simpleFraction B){
        int a1 = A.getX(), a2 = A.getY();
        int b1 = B.getX(), b2 = B.getY();
        simpleFraction C = new simpleFraction(a1 * b1, a2 * b2);
        return C;
    }

    public static void main(String[] args) {
	    simpleFraction A = new simpleFraction(4, 6);
        simpleFraction B = new simpleFraction(5, 6);
        simpleFraction C = fractionPlus(A, B);
        simpleFraction D = fractionMul(A, B);
        System.out.println(C);
        System.out.println(D);
    }
}
