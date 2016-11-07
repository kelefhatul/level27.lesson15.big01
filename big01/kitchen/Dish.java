package com.javarush.test.level27.lesson15.big01.kitchen;


/**
 * Created by root on 11/7/2016.
 */
public enum  Dish{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);


    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        String resultString;
        StringBuilder sb = new StringBuilder();
        for (Dish list:Dish.values()
             ) {
            sb.append(list).append(", ");
        }

        resultString = sb.toString().substring(0,sb.toString().length()-2);

        return resultString;
    }
}
