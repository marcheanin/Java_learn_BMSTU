package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class BigIntegerTable {
    private ArrayList<myBigInteger> numbers;
    private int nok;

    BigIntegerTable() {
        numbers = new ArrayList<>();
        nok = -1;
    }

    void add(BigInteger x){
        numbers.add(new myBigInteger(x));
        if (nok == -1) nok = x.intValue();
        else nok = (x.intValue() * nok) / gcd(nok, x.intValue());
        //System.out.println(nok);
    }

    int gcd(int a, int b){
        if (b == 0){
            return a;
        } else{
            return gcd(b,a % b);
        }
    }

    public Stream<BigInteger> primeStream(){
        ArrayList<BigInteger> result = new ArrayList<>();
        numbers.stream()
                .filter(myBigInteger::isPrime)
                .forEach(x -> result.add(x.getNum()));
        return result.stream();
    }

    public Optional<myBigInteger> getNok(){
        Optional<myBigInteger> result = Optional.empty();
        Optional<myBigInteger> tmp = numbers
                .stream()
                .filter(x -> x.getNum().intValue() % nok == 0)
                .findAny();
        if (tmp.isPresent()){
            result = Optional.ofNullable(tmp.get());
        }
        return result;
    }

    public String toString(){
        String ans = "";
        for (Object i : numbers){
            ans += i.toString() + " ";
        }
        return ans;
    }
}
