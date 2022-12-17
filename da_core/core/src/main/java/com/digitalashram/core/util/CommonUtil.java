/*
 @author: lateef
 @project: digitalashram
 @created: 17/12/2022 - 4:53 pm
 */
package com.digitalashram.core.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CommonUtil {

    private static final int RANDOM_STRING_LENGTH = 8;
    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String generateRandomString() {
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber(CHAR_LIST);
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private static int getRandomNumber(String list) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(list.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}
