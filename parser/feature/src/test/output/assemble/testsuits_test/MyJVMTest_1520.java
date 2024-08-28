import java.io.*;
import java.util.*;

public class MyJVMTest_1520 {

    static int gotParam1 = 692;

    static int gotParam2 = 867;

    static int gotParam3 = 605;

    static int gotParam4 = 889;

    static int gotParam5 = 476;

    static int gotParam6 = 527;

    static Calendar got = new GregorianCalendar(gotParam1, gotParam2, gotParam3, gotParam4, gotParam5, gotParam6);

    static int expectedParam1 = 926;

    static int expectedParam2 = 766;

    static int expectedParam3 = 5;

    static Calendar expected = new GregorianCalendar(expectedParam1, expectedParam2, expectedParam3);

    static int errorCount = 0;

    Calendar compare(Calendar got, Calendar expected) {
        if (!got.equals(expected)) {
            System.err.println("got " + got + ", expected " + expected);
            errorCount++;
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1520().compare(got, expected);
    }
}
