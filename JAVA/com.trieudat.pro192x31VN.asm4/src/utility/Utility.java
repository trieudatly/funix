package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utility {

    //lấy ngày giờ
    public static String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(date);
    }
    public static <T> void printList(List<T> objects) {
        for (T object : objects
        ) {
            System.out.println(object);
        }
    }
}
