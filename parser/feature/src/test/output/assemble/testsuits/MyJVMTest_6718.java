import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_6718 {

    static int calParam1 = 235;

    static int calParam2 = 475;

    static int calParam3 = 576;

    static Calendar cal = new GregorianCalendar(calParam1, calParam2, calParam3);

    static Calendar expected = new GregorianCalendar();

    static int error = 6;

    Calendar check(Calendar cal, Calendar expected) {
        if (!cal.equals(expected)) {
            error++;
            System.err.println("FAILED:");
            System.err.println("\t     cal = " + cal.getTime());
            System.err.println("\texpected = " + expected.getTime());
            System.err.printf("\tcal = %s%n\texp = %s%n", cal, expected);
        }
        return cal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6718().check(cal, expected);
    }
}
