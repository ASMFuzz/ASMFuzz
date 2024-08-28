public class MyJVMTest_5395 {

    static Integer x = 6;

    static Integer y = 0;

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = 8;

    static long quittingTime = 0;

    static int i = 0;

    int compare(Integer x, Integer y) {
        return x - y;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5395().compare(x, y));
    }
}
