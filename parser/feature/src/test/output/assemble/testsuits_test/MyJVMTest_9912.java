public class MyJVMTest_9912 {

    static String name = "9Sw>)WZhhs";

    static long[] array = new long[10];

    static boolean success = true;

    boolean array_check3(String name) {
        boolean success = true;
        for (int i = 0; i < 3; i++) {
            if (array[i] != i) {
                success = false;
                System.out.println(name + " failed: array[" + i + "] = " + array[i]);
            }
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9912().array_check3(name));
    }
}
