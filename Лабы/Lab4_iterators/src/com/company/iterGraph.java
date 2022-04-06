package com.company;

import java.util.ArrayList;

public class iterGraph implements Iterable {
    private final int n;
    ArrayList<Integer>[] g;
    ArrayList<Integer> vertexes;
    private final int[] used;

    private void dfs(int v){
        used[v] = 1;
        vertexes.add(v);
        for (int i = 0 ; i < g[v].size(); i++){
            int to = g[v].get(i);
            if (used[to] == 0){
                //System.out.printf("%d\n", to);
                dfs(to);
            }
        }
    }

    public iterGraph(ArrayList<Integer>[] x, int n){
        this.n = n;
        g = new ArrayList [n];
        vertexes = new ArrayList<>();
        for (int i = 0; i < n; i++){
            g[i] = new ArrayList<Integer>(x[i]);
        }
        used = new int[n];
        for (int i = 0; i < n; i++) used[i] = 0;
        dfs(0);
    }

    public graphIterator iterator(){
        return new graphIterator();
    }

    private class graphIterator implements java.util.Iterator{
        int index = 0;

        public boolean hasNext() {
            return index < n;
        }

        public Integer next(){
            return vertexes.get(index++);
        }
    }

    public String toString(){
        String ans = "";
        for (int i = 0; i < n; i++){
            //System.out.println(vertexes.get(i));
            String tmp = String.valueOf(vertexes.get(i));
            ans += tmp + " ";
        }
        return ans;
    }

}
