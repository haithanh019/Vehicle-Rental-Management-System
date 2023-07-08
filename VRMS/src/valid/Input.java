/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CheckValidator;

import valid.DataValidator;
import static valid.DataValidator.checkRegex;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author Admin
 */
public class Input {

    /**
     *
     * @param enter_ID_
     * @param customer_id_regex
     * @return
     */
    private Input() {
    }
    ;
    static Scanner scanner = new Scanner(System.in);
    private static final String error_message = "Wrong Input ! Please Re-enter ";
    private static final String regex_not_match = "Input Not Valid ! Please Re-enter ";

    public static String inputString(String mess) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + ":");
            try {
                str = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.println(error_message);
                continue;
            }
            if (str.isEmpty()) {
                System.out.println("Please enter a value.");
                continue;
            }
            return formatString(str);
        }
    }

    static public String inputString(String mess, String regex) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + ":");
            try {
                str = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.println(error_message);
                continue;
            }
            if (str.isEmpty()) {
                System.out.println("Please enter a value.");
                continue;
            }
            boolean isTrue = DataValidator.checkRegex(str, regex);
            if (isTrue) {
                return formatString(str);
            } else {
                System.out.println(regex_not_match);
            }
        }
    }

    private static String formatString(String str) {
        if (!str.contains(" ") || !Character.isUpperCase(str.charAt(0))) {
            String[] words = str.split(" ");
            String formattedString = "";

            for (String word : words) {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String restOfWord = word.substring(1).toLowerCase();

                String formattedWord = firstLetter + restOfWord;
                formattedString += formattedWord + " ";
            }

            return formattedString.trim();
        }

        return str;
    }

    public static int inputInt(String mess, boolean check, Predicate<Integer> duplicate) {
        int intVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                intVar = Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(error_message);
                continue;
            }
            if (check) {
                if (intVar < 0) {
                    System.out.println(mess + " must greater than 0");
                } else {
                    if (duplicate.test(intVar)) {
                        System.out.println(mess + " has exist");
                    } else {
                        return intVar;

                    }
                }
            } else {
                return intVar;
            }
        }
    }

    public static int inputInt(String mess, boolean check) {
        int intVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                intVar = Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(error_message);
                continue;
            }
            if (check) {
                if (intVar < 0) {
                    System.out.println(mess + " must greater than 0");
                } else {

                    return intVar;

                }
            } else {
                return intVar;
            }
        }
    }

}
