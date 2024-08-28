public class MyJVMTest_15289 {

    static int[] a = { 0, 9, 0, 3, -1868780030, -1154170238, 0, -1430774761, 0, 8 };

    int[] init(int[] a) {
        for (int j = 0; j < a.length; j++) {
            a[j] = 0;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15289().init(a);
    }
}
