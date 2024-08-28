import java.io.*;
import java.util.*;

public class MyJVMTest_10739 {

    static int gotParam1 = 762;

    static int gotParam2 = 870;

    static int gotParam3 = 959;

    static int gotParam4 = 868;

    static int gotParam5 = 255;

    static int gotParam6 = 787;

    static Calendar got = new GregorianCalendar(gotParam1, gotParam2, gotParam3, gotParam4, gotParam5, gotParam6);

    static int expectedParam1Param1 = 596;

    static String expectedParam1Param2 = "Mz\\og$#efn";

    static int expectedParam1Param3 = 696;

    static int expectedParam1Param4 = 33;

    static int expectedParam1Param5 = 822;

    static int expectedParam1Param6 = 369;

    static int expectedParam1Param7 = 41;

    static int expectedParam1Param8 = 959;

    static int expectedParam1Param9 = 812;

    static int expectedParam1Param10 = 561;

    static TimeZone expectedParam1 = new SimpleTimeZone(expectedParam1Param1, expectedParam1Param2, expectedParam1Param3, expectedParam1Param4, expectedParam1Param5, expectedParam1Param6, expectedParam1Param7, expectedParam1Param8, expectedParam1Param9, expectedParam1Param10);

    static Calendar expected = new GregorianCalendar(expectedParam1);

    static int errorCount = 0;

    Calendar compare(Calendar got, Calendar expected) {
        if (!got.equals(expected)) {
            System.err.println("got " + got + ", expected " + expected);
            errorCount++;
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10739().compare(got, expected);
    }
}
