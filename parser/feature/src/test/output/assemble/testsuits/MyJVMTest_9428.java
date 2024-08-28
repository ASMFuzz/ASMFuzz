public class MyJVMTest_9428 {

    static int limit = 597792932;

    static boolean[] array = { false, true, true, true, true, false, true, false, false, false };

    static boolean barrier = false;

    boolean test(int limit, boolean[] array) {
        for (int i = 0; i < limit; ) {
            i++;
            if (array[i]) {
                if (i < limit) {
                    return true;
                }
                return false;
            }
            barrier = true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9428().test(limit, array));
    }
}
