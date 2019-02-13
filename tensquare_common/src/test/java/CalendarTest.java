import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {


    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        System.out.println(cal.getTime());
        System.out.println("---");
        System.out.println(new Date());
        System.out.println("--");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime beforeday = localDateTime.minusDays(1);
        System.out.println(beforeday);

    }
}
