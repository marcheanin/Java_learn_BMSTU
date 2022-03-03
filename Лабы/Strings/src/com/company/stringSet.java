package com.company;

import java.util.HashSet;

public class stringSet implements Comparable <stringSet>{
    private String[] s;
    public stringSet(String[] s){
        this.s = s;
    }

    public int countRep(){
        HashSet <String>[] a;
        a = new HashSet [this.s.length];
        for(int i = 0; i < this.s.length; i++){
            a[i] = new HashSet<String>();
            for(int j = 0; j < this.s[i].length(); j++){
                a[i].add(String.valueOf(this.s[i].charAt(j)));
            }
        }
        for (int i = 1; i < s.length; i++){
            a[0].retainAll(a[i]);
        }
        return a[0].size();
    }

    public int compareTo(stringSet obj){
        if (countRep() < obj.countRep()) return -1;
        if (countRep() == obj.countRep()) return 0;
        return 1;
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < this.s.length; i++){
            res += s[i];
            if (i != this.s.length - 1) res += '\n';
        }
        return res + '\n' + countRep();
    }


}
