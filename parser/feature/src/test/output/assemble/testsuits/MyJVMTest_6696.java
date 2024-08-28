import static java.util.GregorianCalendar.*;

public class MyJVMTest_6696 {

    static int era = -905488316;

    static int year = 1;

    static int month = 2;

    static int day = 1;

    static int dayOfWeek = 1932676510;

    static int milliseconds = 0;

    static int gmtOffset = 8;

    static int dstOffset = -882393130;

    int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
        return gmtOffset + dstOffset;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6696().getOffset(era, year, month, day, dayOfWeek, milliseconds));
    }
}
