package com.xcv58.java.string_matching_algorithms;

public class KMP implements Match {
    public int indexOf(String pattern, String s) {
        if (pattern == null || s == null) {
            return -1;
        }

        if ("".equals(pattern)) {
            return 0;
        }

        if ("".equals(s)) {
            return -1;
        }

        int[] kmpArray = getKMPArray(pattern);

        for (int i = 0, j = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != pattern.charAt(j)) {
                j = kmpArray[j];
            }

            if (s.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == kmpArray.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getKMPArray(String pattern) {
        int[] array = new int[pattern.length()];
        if ("".equals(pattern) || pattern.length() < 2) {
            return array;
        }
        char[] charArray = pattern.toCharArray();

        for (int i = 1; i < charArray.length - 1; i++) {
            int anchor = array[i];
            while (anchor > 0 && charArray[anchor] != charArray[i]) {
                anchor = array[anchor];
            }
            array[i + 1] = (charArray[anchor] == charArray[i]) ? anchor + 1 : 0;
        }
//            0
//             1
//            0, 01
//            12, 2
//            0, 01, 012
//            123, 23, 3
//            0, 01, 012, 0123
//            1234, 234, 34, 4
//            0, 01, 012, 0123, 01234
//            12345, 2345, 345, 45, 5
        return array;
    }
}
