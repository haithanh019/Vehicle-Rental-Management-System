/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import utils.DataValidator;
import static utils.DataValidator.checkRegex;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author Admin
 */
public class Input {


    private Input() {
    }
    ;
    static Scanner scanner = new Scanner(System.in);
    private static final String error_message = "Wrong Input ! Please Re-enter ";
    private static final String regex_not_match = "Input Not Valid ! Please Re-enter ";

    public static String inputString(String mess) {
        String str;
        while (true) {
            System.out.print(mess);
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
            System.out.print(mess);
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
            System.out.println(mess);
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
            System.out.println(mess);
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
    
    public static double getDouble(String request) {
        double x;
        do {
            try {
                System.out.print(request + ": ");
                x = Double.parseDouble(scanner.nextLine());
                return x;
            } catch (Exception e) {
                System.out.println("Data error! Please try again.");
            }
        } while (true);

    }
    
    public static double getAnPositiveDouble(String request) {
        double temp;
        do {
            temp = getDouble(request);
        } while (!isAPositiveNumber(temp));
        return temp;
    }
    
    public static boolean isAPositiveNumber(double n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number (>0)!");
            return false;
        }
        return true;
    }
    
    public static Date convertStringToDate(String dateString, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDateOfBirth(String inputMsg) {
        Date parsedDate = null;
        boolean isValidDate = false;

        while (!isValidDate) {
            String dob = inputString(inputMsg);
            if (dob == null) {
                return null;
            }
            try {
                parsedDate = convertStringToDate(dob, "dd/MM/yyyy");
                // Kiểm tra năm nhuận
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parsedDate);

                if (isDateValid(parsedDate)) {
                    isValidDate = true;
                } else {
                    System.out.println("Invalid date!");
                }
            } catch (Exception e) {
                System.out.println("Invalid date!");
            }
        }

        return parsedDate;
    }

    public static boolean isDateValid(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, cần cộng 1
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Kiểm tra tính hợp lệ của năm, tháng và ngày
        if (year < 1) {
            return false; // Năm phải lớn hơn 0
        }

        if (month < 1 || month > 12) {
            return false; // Tháng phải nằm trong khoảng từ 1 đến 12
        }

        if (day < 1 || day > getDaysInMonth(month, year)) {
            return false; // Ngày phải nằm trong khoảng hợp lệ cho tháng và năm tương ứng
        }

        return true; // Ngày tháng hợp lệ
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28; // Tháng 2 có 28 hoặc 29 ngày (nếu là năm nhuận)
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30; // Các tháng 4, 6, 9, 11 có 30 ngày
        } else {
            return 31; // Các tháng còn lại có 31 ngày
        }
    }

}
