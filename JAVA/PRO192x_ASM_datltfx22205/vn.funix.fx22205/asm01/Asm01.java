package asm01;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Asm01 {
    static Scanner sc = new Scanner(System.in);
    static String cccd = "";
    static String[] arrMaTinh = new String[]{
            "001", "002", "004", "006", "008", "010", "011",
            "012", "014", "015", "017", "019", "020", "022",
            "024", "025", "026", "027", "030", "031", "033",
            "034", "035", "036", "037", "038", "040", "042",
            "044", "045", "046", "048", "049", "051", "052",
            "054", "056", "058", "060", "062", "064", "066",
            "067", "068", "070", "072", "074", "075", "077",
            "079", "080", "082", "083", "084", "086", "087",
            "089", "091", "092", "093", "094", "095", "096"};
    static String[] arrTenTinh = new String[]{
            "Hà Nội", "Hà Giang", "Cao Bằng", "Bắc Kạn", "Tuyên Quang", "Lào Cai", "Điện Biên",
            "Lai Châu", "Sơn La", "Yên Bái", "Hòa Bình", "Thái Nguyên", "Lạng Sơn", "Quảng Ninh",
            "Bắc Giang", "Phú Thọ", "Vĩnh Phúc", "Bắc Ninh", "Hải Dương", "Hải Phòng", "Hưng Yên",
            "Thái Bình", "Hà Nam", "Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh",
            "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế", "Đà Nẵng", "Quảng Nam", "Quảng Ngãi", "Bình Định",
            "Phú Yên", "Khánh Hòa", "Ninh Thuận", "Bình Thuận", "Kon Tum", "Gia Lai", "Đắk Lắk",
            "Đắk Nông", "Lâm Đồng", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai", "Bà Rịa - Vũng Tàu",
            "Hồ Chí Minh", "Long An", "Tiền Giang", "Bến Tre", "Trà Vinh", "Vĩnh Long", "Đồng Tháp",
            "An Giang", "Kiên Giang", "Cần Thơ", "Hậu Giang", "Sóc Trăng", "Bạc Liêu", "Cà Mau"};
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final String ALL = alpha + alphaUpperCase + digits + specials;

    private static Random generator = new Random();

    /**
     * Random string with a-zA-Z0-9, not included special characters
     */
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    static public String randomAlphaNumeric() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(arrMaTinh));
        //System.out.println(Arrays.toString(arrTenTinh));

        System.out.println("randomString1: " + randomAlphaNumeric());
        final String AUTHOR = "fx22205";
        final String VERSION = "1.0.0";
        int choice;
        menu(AUTHOR, VERSION);
        while (true) {
            System.out.print("Chuc nang: ");
            try {
                choice = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Nhap 1 hoac 0");
                continue;
            }
            switch (choice) {
                case 1:
                    authenticator();
                    nhapCCCD();
                    cccdMenu();
                    break;
                case 0:
                    System.out.println("Bye Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhap 1 hoac 0");
                    break;
            }
        }
    }

    private static void nhapCCCD() {
        boolean cccdOK = false;
        sc.nextLine();
        while (!cccdOK) {
            System.out.print("Nhap so CCCD: ");
            String cccdPattern = "^\\d{12}$";
            cccd = sc.nextLine().trim().toLowerCase();
            //System.out.println("cccd= " + cccd);
            if (cccd.compareTo("no") == 0) {
                System.out.println("Bye Bye");
                System.exit(0);
            } else if (!Pattern.matches(cccdPattern, cccd)) {
                System.out.println("So CCCD khong hop le.\nVui long nhap lai hoac 'No' de thoat");
            } else {
                cccdOK = true;
            }
        }

    }

    private static void cccdMenu() {

        int cccdChoice;
        while (true) {
            System.out.println("\t| 1. Kiem tra noi sinh\n\t| 2. Kiem tra nam sinh, gioi tinh\n\t| 3. Kiem tra so ngau nhien\n\t| 0. Thoat");
            System.out.print("Chon chuc nang: ");
            try {
                cccdChoice = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Nhap 0 1 2 3");
                continue;
            }
            switch (cccdChoice) {
                case 1:
                    showBirthPlace();
                    break;
                case 2:
                    showBirthYear();
                    break;
                case 3:
                    showNumber();
                    break;
                case 0:
                    System.out.println("Bye Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhap 0 1 2 3");
                    break;
            }
        }

    }

    private static void showNumber() {
        String number = cccd.substring(6, 12);
        System.out.println("So ngau nhien: " + number);
    }

    private static void showBirthYear() {
        int birhYear = Integer.parseInt(cccd.substring(4, 6));
        String gender = "";
        //System.out.println("Gioi tinh: " + gender);
        //System.out.println("Nam Sinh: " + birhYear);
        int century = 0;
        switch (Integer.parseInt(cccd.substring(3, 4))) {
            case 1:
                gender = "Nam";
                century = 1900;
                break;
            case 0:
                gender = "Nu";
                century = 1900;
                break;
            case 2:
                gender = "Nam";
                century = 2000;
                break;
            case 3:
                gender = "Nu";
                century = 2000;
                break;
            case 4:
                gender = "Nam";
                century = 2100;
                break;
            case 5:
                gender = "Nu";
                century = 2100;
                break;
            case 6:
                gender = "Nam";
                century = 2200;
                break;
            case 7:
                gender = "Nu";
                century = 2200;
                break;
            case 8:
                gender = "Nam";
                century = 2300;
                break;
            case 9:
                gender = "Nu";
                century = 2300;
                break;
            default:
                gender = "khong xac dinh";
                break;
        }
        System.out.println("Gioi tinh: " + gender + "| Nam sinh: " + (century + birhYear));
    }

    private static void showBirthPlace() {
        String birthPlaceCode = cccd.substring(0, 3);
        //System.out.println(birthPlaceCode);
        for (int i = 0; i < arrMaTinh.length; i++) {
            if (arrMaTinh[i].compareTo(birthPlaceCode) == 0) {
                System.out.println("Noi Sinh: " + arrTenTinh[i]);
            }
        }
    }


    private static void authenticator() {
        Random rand = new Random();
        int answer = 0;
        //int auth = rand.nextInt((max - min) + 1) + min;
        //int auth = rand.nextInt((999-100)+1)+100;
        int auth = rand.nextInt(900) + 100;
        System.out.println("Nhap ma xac thuc: " + auth);
        while (true) {
            System.out.print("Nhap ma xac thuc: ");
            try {
                answer = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai");
                continue;
            }
            if (auth == answer) {
                break;
            } else {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai");
            }
        }

    }

    private static void menu(String author, String version) {
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| NGAN HANG SO | " + author + "@v" + version + "           |");
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| 1.Nhap CCCD                             |");
        System.out.println("| 0.Thoat                                 |");
        System.out.println("+----------+-------------------+----------+");
    }
}
