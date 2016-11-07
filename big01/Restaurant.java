package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;


/**
 * Created by root on 11/7/2016.
 */
public class Restaurant {
    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(5);


        Cook cook = new Cook("Test");

        tablet.addObserver(cook);
        Waitor waiter = new Waitor();
        cook.addObserver(waiter);
        tablet.createOrder();





    }
}
