public class MyJVMTest_734 {

    static String name = "\"`JyZdQ5#h";

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
        System.out.println(new MyJVMTest_734().array_check3(name));
    }
}
