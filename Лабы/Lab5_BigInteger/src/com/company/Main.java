package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
	    BigIntegerTable s = new BigIntegerTable();
        s.add(new BigInteger("3"));
        s.add(new BigInteger("2"));
        s.add(new BigInteger("15"));
        s.add(new BigInteger("10"));
        s.add(new BigInteger("30"));

        System.out.println(s);
        s.primeStream().sorted().forEach(System.out::println);
        System.out.println(s.getNok());
    }
}
