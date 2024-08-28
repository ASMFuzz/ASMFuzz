public class MyJVMTest_14820 {

    static Integer x = 2;

    static Integer y = 8;

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = -891202885;

    static long quittingTime = -9223372036854775808L;

    static int i = 0;

    int compare(Integer x, Integer y) {
        return x - y;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14820().compare(x, y));
    }
}
