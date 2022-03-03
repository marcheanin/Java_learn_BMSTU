package com.company;

import java.util.Arrays ;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int m;
        stringSet[] sets = new stringSet[n];
        for(int i = 0; i < n; i++){
            m = in.nextInt();
            String[] s = new String[m];
            for(int j = 0; j < m; j++){
                s[j] = in.next();
            }
            sets[i] = new stringSet(s);
        }
        Arrays.sort(sets);
        for (int i = 0; i < n; i++){
            System.out.println(sets[i]);
        }
    }
}
