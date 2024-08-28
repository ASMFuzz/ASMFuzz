public class MyJVMTest_9907 {

    static int[] a = { 0, 0, 0, 0, 753307719, 1, -847080968, 204165929, 7, 0 };

    static int[] b = { 8, 8, 2, 0, -1102182468, 3, 3, 0, 0, 0 };

    int[] test_cp_oppos(int[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9907().test_cp_oppos(a, b);
    }
}
