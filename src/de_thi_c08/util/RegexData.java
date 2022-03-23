package de_thi_c08.util;

import java.util.Scanner;

public class RegexData {
    static Scanner sc = new Scanner(System.in);
    public static String regexStr(String temp, String regex, String error){
        boolean check = true;
        do {
            if (temp.matches(regex)){
                check = false;
            } else {
                System.out.print(error);
                temp = sc.nextLine();
            }
        } while (check);
        return temp;
    }
}
