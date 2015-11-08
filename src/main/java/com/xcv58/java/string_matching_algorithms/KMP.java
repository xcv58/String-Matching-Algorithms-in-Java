package com.xcv58.java.string_matching_algorithms;

public class KMP implements Match {
    public int indexOf(String pattern, String s) {
        if (pattern == null || s == null) {
            return -1;
        }

        int[] kmpArray = getKMPArray(pattern);

        for (int i = 0; i < s.length() - pattern.length() + 1; i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (s.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    i += kmpArray[j];
                    break;
                }
            }
            if (match) {
                return i;
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
        for (int i = 1; i < charArray.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                boolean match = true;
                for (int k = 0; k < j; k++) {
                    if (charArray[k] != charArray[k + i - j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    array[i] = j;
                    break;
                }
            }
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