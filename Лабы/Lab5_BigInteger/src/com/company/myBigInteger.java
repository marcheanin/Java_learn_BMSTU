package com.company;

import java.math.BigInteger;

public class myBigInteger implements Comparable<myBigInteger> {
    private BigInteger num;
    private int len;

    public myBigInteger (BigInteger x){
        num = x;
        len = num.bitLength();
    }

    public boolean isPrime(){
        return num.isProbablePrime(1);
    }

    public BigInteger getNum(){
        return num;
    }

    public int getLen(){
        return len;
    }

    public int compareTo(myBigInteger x){
        if (len > x.getLen()) return 1;
        else if (len == x.getLen()) return 0;
        return -1;
    }

    public String toString(){
        return num.toString();
    }
}
