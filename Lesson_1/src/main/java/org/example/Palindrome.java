package org.example;

public class Palindrome {

    public Palindrome(String str) {
    }

      public static boolean isPalindrome (String grtString) {

        int length = grtString.length();

        for (int i = 0; i < length/2; i++) {
            if (grtString.charAt(i) != grtString.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

