import static java.util.GregorianCalendar.*;

public class MyJVMTest_16884 {

    static long date = 9223372036854775807L;

    static int gmtOffset = 9;

    static int dstOffset = 8;

    int getOffset(long date) {
        return gmtOffset + dstOffset;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16884().getOffset(date));
    }
}
