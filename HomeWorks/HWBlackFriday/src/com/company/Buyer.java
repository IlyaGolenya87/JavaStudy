package com.company;

public class Buyer {
    private int token;
    private boolean isHappy;

    public Buyer (int token){
        this.token = token;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }
}


