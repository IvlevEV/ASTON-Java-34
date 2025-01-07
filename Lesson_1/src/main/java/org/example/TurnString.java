package org.example;

public class TurnString {


    public TurnString(String str) {
    }

    public static String turnString (String grtString) {

        if (grtString.length() <= 1) {
            return grtString;
        }
        return turnString(grtString.substring(1)) + grtString.charAt(0);
    }
}
