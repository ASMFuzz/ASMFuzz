import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_10298 {

    static int year = 0;

    static int month = 0;

    static int dayOfMonth = 0;

    static int amount = 1844619760;

    static int expected = 6;

    static int errors = 0;

    int test(int year, int month, int dayOfMonth, int amount, int expected) {
        Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
        int week = calendar.get(WEEK_OF_YEAR);
        calendar.roll(WEEK_OF_YEAR, amount);
        int got = calendar.get(WEEK_OF_YEAR);
        int y = calendar.get(YEAR);
        if (got != expected || y != year) {
            String date = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
            System.err.printf("%s: roll %+d: got: %d,%2d; expected: %d,%2d%n", date, amount, y, got, year, expected);
            errors++;
        }
        return year;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10298().test(year, month, dayOfMonth, amount, expected);
    }
}
