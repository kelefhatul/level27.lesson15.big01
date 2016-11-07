package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by root on 11/7/2016.
 */
public enum  Dish {
    Fish, Steak, Soup, Juice, Water;
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
