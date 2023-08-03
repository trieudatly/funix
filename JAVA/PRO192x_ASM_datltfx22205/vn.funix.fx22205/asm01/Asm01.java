package asm01;
//PRO192x.3.1.VN -Assignment 1- Lý Triệu Đạt - datltfx22205@funix.edu.vn

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Asm01 {
    //tạo scanner dùng chung
    static Scanner sc = new Scanner(System.in);
    //tạo biến cccd để lưu căn cước nhập vào
    static String cccd = "";
    //tạo mảng arrMaTinh bao gồm mã số các tỉnh thành thuộc trung ương
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
    //tạo mảng arrTenTinh bao gồm tên các tỉnh thành thuộc trung ương, có thứ tự theo arrMaTinh
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


    public static void main(String[] args) {
        //tạo 2 hằng lưu tác giả và phiên bản
        final String AUTHOR = "fx22205";
        final String VERSION = "1.0.0";

        //biến choice dùng để lưu lựa chọn của user
        int choice;
        //gọi phương thức menu với 2 tham số author và version
        menu(AUTHOR, VERSION);
        while (true) {
            System.out.print("Chuc nang: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số => in ra thông báo lỗi
            try {
                choice = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Nhap 1 hoac 0");
                continue;
            }
            switch (choice) {
                case 1:
                    //xác thực
                    if (authMenu()) {
                        //nhập CCCD
                        if (getCCCD()) {
                            //hiện menu chức năng CCCD
                            cccdMenu();
                        }
                    }
                    break;
                case 0:
                    //thông báo tạm biệt
                    System.out.println("Bye Bye");
                    //thoát chương trình
                    System.exit(0);
                    break;
                default:
                    //nếu người dùng nhập một số khác 1 hoặc 0 => in ra thông báo lỗi
                    System.out.println("Nhap 1 hoac 0");
                    break;
            }
        }
    }

    //Menu Chính
    private static void menu(String author, String version) {
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| NGAN HANG SO | " + author + "@v" + version + "           |");
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| 1.Nhap CCCD                             |");
        System.out.println("| 0.Thoat                                 |");
        System.out.println("+----------+-------------------+----------+");
    }

    // Xác thực bảo mật
    private static boolean authMenu() {
        int authChoice;
        sc.nextLine();
        //vòng lặp chạy liên tục cho đến khi thỏa mảng 1 trong 2 switch case 1 | 2
        while (true) {
            System.out.println("\tVui long chon hinh thuc bao mat");
            System.out.println("\t| 1. Do kho 'Don Gian'\n\t| 2. Do kho 'Phuc Tap'\n\t| 0. Thoat");
            System.out.print("Chon chuc nang: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số => in ra thông báo lỗi
            try {
                authChoice = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Nhap 0 1 2 ");
                continue;
            }
            switch (authChoice) {
                case 1:
                    return authEasy();
                case 2:
                    return authHard();
                case 0:
                    System.out.println("Bye Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhap 0 1 2");
                    break;
            }
        }
    }

    private static boolean authHard() {
        sc.nextLine();
        //tạo 1 đối tượng kiểu Random
        Random rand = new Random();
        //tạo 1 String bao gồm  a-z và A-Z và 0-9
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String answerHard = "";
        //asm1 yêu cầu mã có độ dài 6 ký tự
        //tạo 1 đối tượng StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            //mỗi lần lặp sẽ tạo 1 số ngẫu nhiên có giới hạn từ 0 đến độ dài chuỗi alpha
            int number = rand.nextInt(alpha.length());
            //lấy 1 char trong chuỗi alpha, có index là number
            char ch = alpha.charAt(number);
            //nối char đó vào sb
            sb.append(ch);
        }
        //chuyển StringBuilder sb thành chuỗi auth
        String auth = sb.toString();
        System.out.println("Nhap ma xac thuc: " + auth);
        while (true) {
            System.out.print("Nhap ma xac thuc: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số => in ra thông báo lỗi
            try {
                answerHard = sc.next();
            } catch (Exception e) {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai");
                continue;
            }
            if (auth.compareTo(answerHard) == 0) {
                //so sánh auth và answerHard do user nhập vào
                //nếu đúng trả về true
                return true;
            } else {
                //nếu sai in thông báo lỗi
                System.out.println("Ma xac thuc khong dung. Vui long thu lai");
            }
        }
    }

    private static boolean authEasy() {
        //tạo 1 đối tượng kiểu Random
        Random rand = new Random();
        int answerEasy = 0;
        //tạo biến auth là 1 số ngẫu nhiên theo giới hạn trong 100-999
        //int auth = rand.nextInt((max - min) + 1) + min;
        //int auth = rand.nextInt((999-100)+1)+100;
        int auth = rand.nextInt(900) + 100;
        System.out.println("Nhap ma xac thuc: " + auth);
        while (true) {
            System.out.print("Nhap ma xac thuc: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số => in ra thông báo lỗi
            try {
                answerEasy = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai");
                continue;
            }
            if (auth == answerEasy) {
                //so sánh auth và answerEasy do user nhập vào
                //nếu đúng trả về true
                return true;
            } else {
                //nếu sai in thông báo lỗi
                System.out.println("Ma xac thuc khong dung. Vui long thu lai");
            }
        }
    }

    //Xử lý CCCD
    private static boolean getCCCD() {
        sc.nextLine();
        while (true) {
            System.out.print("Nhap so CCCD: ");
            //tạo 1 String với pattern dùng dể so khớp
            // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
            // \\d tức là số bất kì từ 0-9
            // {12} lặp lại 12 lần vì số CCCD có 12 chữ số
            String cccdPattern = "^\\d{12}$";
            //nhập CCCD, cắt bỏ khoảng trắng ở đầu đuôi,tất cả viết thường
            cccd = sc.nextLine().trim().toLowerCase();
            if (cccd.compareTo("no") == 0) {
                //nếu cccd bằng "no" => thoát
                System.out.println("Bye Bye");
                System.exit(0);
            } else if (!Pattern.matches(cccdPattern, cccd)) {
                //nếu cccd không khớp pattern => in thông báo lỗi
                System.out.println("So CCCD khong hop le.\nVui long nhap lai hoac 'No' de thoat");
            } else {
                //nếu cccd khớp pattern tức là cccd hợp lệ
                return true;
            }
        }

    }

    private static void cccdMenu() {
        int cccdChoice;
        while (true) {
            System.out.println("\t| 1. Kiem tra noi sinh\n\t| 2. Kiem tra nam sinh, gioi tinh\n\t| 3. Kiem tra so ngau nhien\n\t| 0. Thoat");
            System.out.print("Chon chuc nang: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số => in ra thông báo lỗi
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
        //tạo 1 sub String từ index 6 đến 12
        String number = cccd.substring(6, 12);
        System.out.println("So ngau nhien: " + number);
    }

    private static void showBirthYear() {
        //tạo 1 subString từ index 4 đến 6
        int birhYear = Integer.parseInt(cccd.substring(4, 6));
        String gender = "";
        //biến century để lưu thế kỷ của cccd
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
        String birthPlace = "";
        //tạo 1 subString từ index 0 đến 3
        String birthPlaceCode = cccd.substring(0, 3);
        for (int i = 0; i < arrMaTinh.length; i++) {
            //tìm mã tĩnh bằng với birthPlaceCode
            if (arrMaTinh[i].compareTo(birthPlaceCode) == 0) {
                //in ra tên tĩnh có index bằng mã tĩnh vừa tìm được
                birthPlace = arrTenTinh[i];
            }
        }
        if (birthPlace.compareTo("") == 0) {
            //nếu không tìm được tên tĩnh theo mã tĩnh
            System.out.println("Noi Sinh: Chua xac dinh");
        } else {
            //nếu tìm được tên tĩnh theo mã tĩnh
            System.out.println("Noi Sinh: " + birthPlace);
        }
    }
}
