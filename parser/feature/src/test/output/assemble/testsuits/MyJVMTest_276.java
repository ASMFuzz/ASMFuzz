public class MyJVMTest_276 {

    static int limit = -771509779;

    static boolean[] array = { true, true, false, false, false, true, true, false, false, false };

    static boolean barrier = true;

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
        System.out.println(new MyJVMTest_276().test(limit, array));
    }
}
