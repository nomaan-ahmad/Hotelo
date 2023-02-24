package com.Hotelo;

import java.util.HashSet;

public class TestClass {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);

        boolean flag = false;
        while (!flag) {
            try {
                String input = Input.line().trim();
                if (input.toLowerCase().charAt(0) == 'x') {
                    flag = true;
                    System.out.println("Exiting");
                }
                int hotelID = Integer.parseInt(input);
                if (hs.contains(hotelID)) flag = true;
                else System.out.println("Type correct HotelID");
            } catch (NumberFormatException e) {
                if (flag) break;
                System.out.println("Wrong input format");
                System.out.println("Try again");
            }
        }
    }
}
