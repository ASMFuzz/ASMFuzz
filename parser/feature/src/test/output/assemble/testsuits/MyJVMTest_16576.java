import static java.util.GregorianCalendar.*;

public class MyJVMTest_16576 {

    static int gmtOffset = 2;

    static int dstOffset = 0;

    boolean useDaylightTime() {
        return dstOffset != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16576().useDaylightTime());
    }
}
