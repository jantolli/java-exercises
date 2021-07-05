package com.devel.hr;

/**
 * Write a sample code to print the fgollowing pattern
 * *
 * * *
 * * * *
 * * * * *
 */
public class PrintPattern {

    public static void printUsingLoop() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }


    public static void printWithRecursion(int i) {
        if (i > 0) {
            printWithRecursion(--i);
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        PrintPattern.printUsingLoop();
        PrintPattern.printWithRecursion(4);


    }
}
