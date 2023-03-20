package com.Hotelo.userInput;
import java.util.Scanner;

public class Input {
    public static String line() {
        Scanner in = new Scanner(System.in);

        return in.nextLine();
    }

    public static char singleChar() {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();

        return word.charAt(0);
    }

    public static char yesOrNo() {
        Scanner in = new Scanner(System.in);
        char ch; // will store selected option in ch
        while (true) {
            System.out.println("Choose 'Y' for yes and 'N' for no");
            ch = in.nextLine().charAt(0);
            if (ch == 'y' || ch == 'n') return ch;
            else System.out.println("Select correct option :)");
        }
    }
}
