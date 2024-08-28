import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_588 {

    static int year = 0;

    int getDelta(int year) {
        return (year >= 1970 && year <= 2039) ? 1 : 1 << 13;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_588().getDelta(year));
    }
}
