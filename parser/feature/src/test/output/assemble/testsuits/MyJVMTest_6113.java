public class MyJVMTest_6113 {

    static String name = "vwEQ>b&tge";

    static long[] array = new long[10];

    static boolean success = true;

    boolean array_check(String name) {
        boolean success = true;
        if (array[0] != 999) {
            success = false;
            System.out.println(name + " failed: array[0] = " + array[0]);
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6113().array_check(name));
    }
}
