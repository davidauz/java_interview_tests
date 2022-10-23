package linkedin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class test_dates {

    public void go() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))); // new addition in Java 9
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
    }
}
