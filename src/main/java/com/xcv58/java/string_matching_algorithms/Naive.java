package com.xcv58.java.string_matching_algorithms;

public class Naive implements Match {
    @Override
    public int indexOf(String pattern, String s) {
        if (pattern == null || s == null) {
            return -1;
        }

        for (int i = 0; i < s.length() - pattern.length() + 1; i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (s.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }
}
