package com.devel.hr;

import java.io.*;
import java.util.*;

public class HackerRankTests {

    static int flatlandSpaceStations(int n, int[] c) {
        int max = 0;
        if (c.length == n) {
            return max;
        }
        Arrays.sort(c);
        if (c.length == 1) {
            int left = Math.abs((c[0] - 0));
            int right = Math.abs((c[0] - n));
            int min = Math.min(left, right);
            max = Math.max(min, max);
        } else {
            for (int i = 0; i < c.length - 1; i++) {
                int min = Math.abs((c[i] - c[i+1]) / 2);
                max = Math.max(min, max);
            }
        }
        max = Math.max(Math.abs(c[0] - 0), max);

        max = Math.max(Math.abs(c[c.length - 1] - n) - 1, max);

        System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws IOException {

        int[] list = {68, 81, 46, 54, 30, 11, 19, 23, 22, 12, 38, 91, 48, 75, 26, 86, 29, 83, 62};
        int total = 95; // expected 11

//        int[] list = {99};
//        int total = 100; // expected 99

//        int[] list = {13, 1, 11, 10, 6};
//        int total = 20; // expected 6

        int result = flatlandSpaceStations(total, list);

    }
}
