package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 11/7/2016.
 */
public class ConsoleHelper {
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String inString = "";
        try {
            inString = keyboard.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inString;
    }

    public static List<Dish> getAllDishesForOrder()throws IllegalArgumentException{
        List<Dish> orderList = new ArrayList<>();
        writeMessage("Choose from list: " + Dish.allDishesToString());
        String tmp;
        while (true){
            tmp=readString();
            if ("exit".equalsIgnoreCase(tmp)){
                break;
            }
            try {
                orderList.add(Dish.valueOf(tmp));
            } catch (IllegalArgumentException e) {
                writeMessage(tmp + " is not detected");
                continue;
            }

        }
        return orderList;
    }
}
