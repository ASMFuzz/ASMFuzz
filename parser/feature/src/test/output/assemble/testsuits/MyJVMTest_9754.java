import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_9754 {

    static int year = 4;

    int getDelta(int year) {
        return (year >= 1970 && year <= 2039) ? 1 : 1 << 13;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9754().getDelta(year));
    }
}
