package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.*;

/**
 * Created by root on 11/7/2016.
 */
public class Tablet extends Observable {
    private int number;
    final static Logger logger = Logger.getLogger(Tablet.class.getName());
    private List<Observer> observers;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            notifyObservers(order);
        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }


    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}
