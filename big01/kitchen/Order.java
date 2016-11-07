package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by root on 11/7/2016.
 */
public class Order {
    private Tablet tablet;
    private List<Dish> dishes;

    public Order() {
    }

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();

    }

    @Override
    public String toString() {
        String result="";
        if (dishes.size() ==0 || dishes ==null){
            return result;
        }
        result = "Your order: " + dishes +" of " + tablet.toString();
        return result;
    }

    public int getTotalCookingTime(){
            int sum=0;
            for (Dish dishFromList: dishes
                 ) {
                sum +=dishFromList.getDuration();
            }
            return sum;
    }
    public boolean isEmpty(){
        return dishes.size()==0 || dishes==null;
    }
}
