import static java.util.GregorianCalendar.*;

public class MyJVMTest_7355 {

    static long date = -9223372036854775808L;

    static int gmtOffset = 9;

    static int dstOffset = 5;

    int getOffset(long date) {
        return gmtOffset + dstOffset;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7355().getOffset(date));
    }
}
