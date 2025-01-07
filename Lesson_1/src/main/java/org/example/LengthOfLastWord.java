package org.example;

public class LengthOfLastWord {

    public LengthOfLastWord(String str) {
    }

    public static Integer lengthOfLastWord(String grtString) {

        int right = grtString.length() - 1;
        while (right >= 0 && grtString.charAt(right) == ' ') {
            right--;
        }

        int left = right;
        while (left >= 0 && grtString.charAt(left) != ' ') {
            left--;
        }

        return right - left;
    }
}

