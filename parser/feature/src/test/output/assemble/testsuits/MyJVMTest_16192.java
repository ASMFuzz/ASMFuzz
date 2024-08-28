import static java.util.GregorianCalendar.*;

public class MyJVMTest_16192 {

    static int era = 1;

    static int year = 9;

    static int month = 3;

    static int day = 0;

    static int dayOfWeek = 0;

    static int milliseconds = 4;

    static int gmtOffset = 8;

    static int dstOffset = 1855264573;

    int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
        return gmtOffset + dstOffset;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16192().getOffset(era, year, month, day, dayOfWeek, milliseconds));
    }
}
