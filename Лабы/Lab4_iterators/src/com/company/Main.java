package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a, b;
        ArrayList<Integer>[] s;
        s = new ArrayList[n];
        for (int i = 0; i < n; i++){
            s[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++){
            a = in.nextInt(); b = in.nextInt();
            s[a].add(b);
            s[b].add(a);
        }

        //iterGraph g = new iterGraph(s, n);
       // for (Object o : g) {
       //     System.out.println(o);
        //}
        iterGraph g = new iterGraph(s, n);
        Iterator iterator = g.iterator();
        while(iterator.hasNext()) {
            int x = (int) iterator.next();
            System.out.println(x);
        }
        System.out.println(g);
    }
}
