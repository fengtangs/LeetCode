package com.java.demo;


public class first {
    private int q=1;
    private  int w=2;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof first){
            first obj1 = (first) obj;
            if(this.q == obj1.q && this.w == obj1.w){
                return true;
            }
        }
        return false;
    }



}
