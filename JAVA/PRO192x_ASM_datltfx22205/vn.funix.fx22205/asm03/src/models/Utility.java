package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    public static String getInputWithPattern(String pattern) {
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.compareTo("no") == 0) {
                System.out.println("Bye Bye");
                System.exit(0);
            }
            if (!Pattern.matches(pattern, input)) {
                System.out.print("khong hop le. Vui long nhap lai:");
            } else {
                return input;
            }
        }
    }

    public static String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return dateFormat.format(date);
    }
}
