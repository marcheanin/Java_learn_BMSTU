package com.company;

import static com.company.Main.myGcd;

public class simpleFraction {
    private int x;
    private int y;

    public void simplify(){
        int a = myGcd(this.x, this.y);
        this.x /= a;
        this.y /= a;
    }

    public simpleFraction(int x, int y){
        this.x = x;
        this.y = y;
        simplify();
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public String toString(){
        return this.x + "/" + this.y;
    }


}
