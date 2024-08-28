import static java.util.GregorianCalendar.*;

public class MyJVMTest_7058 {

    static int gmtOffset = 0;

    static int dstOffset = 2;

    boolean useDaylightTime() {
        return dstOffset != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7058().useDaylightTime());
    }
}
