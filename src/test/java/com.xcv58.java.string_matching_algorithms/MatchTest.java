package com.xcv58.java.string_matching_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    @Test public void test() {
        testNaive();
        testKMP();
    }

    private void testNaive() {
        test(new Naive());
    }

    private void testKMP() {
        test(new KMP());
    }

    private void test(Match match) {
        assertEquals("both null values", -1, match.indexOf(null, null));
        assertEquals("pattern is null", -1, match.indexOf("", null));
        assertEquals("string is null", -1, match.indexOf(null, ""));

        assertEquals("begin", 0, match.indexOf("abc", "abcdefg"));
        assertEquals("end", 3, match.indexOf("abc", "efgabc"));
        assertEquals("mid", 3, match.indexOf("abc", "efgabcd"));
        assertEquals("empty pattern", 0, match.indexOf("", "efgabcd"));
        assertEquals("empty string", -1, match.indexOf("abc", ""));
        assertEquals("both empty", 0, match.indexOf("", ""));
    }
}
