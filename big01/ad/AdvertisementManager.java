package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

/**
 * Created by root on 11/7/2016.
 */
public class AdvertisementManager {
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos() {
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;
                long oneScost1 = o1.getAmountPerOneDisplaying() * 1000/o1.getDuration();
                long oneScost2 = o2.getAmountPerOneDisplaying() * 1000/o2.getDuration();

                return Long.compare(oneScost1,oneScost2);
            }
        });
        int timeDisplay =timeSeconds;
        for (Advertisement list: storage.list()
             ) {
            if (timeDisplay < list.getDuration()) {
                continue;
            }
            ConsoleHelper.writeMessage(list.getName() + " is displaying..."
                                        + list.getAmountPerOneDisplaying() + ", "
                                        + list.getAmountPerOneDisplaying()*1000/list.getDuration());
            timeDisplay -=list.getDuration();
            list.revalidate();
        }
        if (timeDisplay == timeSeconds){
            throw new NoVideoAvailableException();
        }



    }
}
