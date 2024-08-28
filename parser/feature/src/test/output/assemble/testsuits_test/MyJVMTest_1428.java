public class MyJVMTest_1428 {

    static String name = "VD6,o{;rC6";

    static long[] array = new long[10];

    static boolean success = true;

    boolean array_check2(String name) {
        boolean success = true;
        for (int i = 0; i < 6; i++) {
            if (array[i] != 999) {
                success = false;
                System.out.println(name + " failed: array[" + i + "] = " + array[i]);
            }
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1428().array_check2(name));
    }
}
