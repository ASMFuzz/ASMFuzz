public class MyJVMTest_3098 {

    static String name = "e}oI/}}=h|";

    static long[] array = new long[10];

    static int[] array4 = new int[1000];

    static boolean success = true;

    boolean array_check5(String name) {
        boolean success = true;
        for (int i = 0; i < 1000; i++) {
            if (array4[i] != 42) {
                success = false;
                System.out.println(name + " failed: array[" + i + "] = " + array4[i]);
            }
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3098().array_check5(name));
    }
}
