package utils;

import java.util.Random;

public class RandomUtils {

    public static String generateRandomNumberSequence() {
        Random random = new Random();
        StringBuilder randomNumber = new StringBuilder();
        for(int i=0;i<3;i++) {
            randomNumber.append(random.nextInt(1000));
        }

        return randomNumber.toString();
    }
}
