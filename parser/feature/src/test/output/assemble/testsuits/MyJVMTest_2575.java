public class MyJVMTest_2575 {

    static String name = "&?,PzrPh[}";

    static long[] array = new long[10];

    static byte[] byte_array = new byte[10];

    static boolean success = true;

    boolean array_check4(String name) {
        boolean success = true;
        for (int i = 0; i < 3; i++) {
            if (byte_array[i] != i) {
                success = false;
                System.out.println(name + " failed: byte_array[" + i + "] = " + byte_array[i]);
            }
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2575().array_check4(name));
    }
}
