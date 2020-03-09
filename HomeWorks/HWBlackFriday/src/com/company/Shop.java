package com.company;

import java.util.ArrayList;

public class Shop {
    ArrayList<Integer> tokens = new ArrayList<>();
    static int goodsOnShelf = 5;

}

class Seller extends Thread {

    @Override
    public void run() {



    }

    public void sell() {
        Shop.goodsOnShelf --;
    }

    public void goToStore() {
        Shop.goodsOnShelf = 5;
    }
}
