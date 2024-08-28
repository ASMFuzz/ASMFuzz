public class MyJVMTest_1571 {

    static byte[] a = { -60, -25, 68, -88, -43, 68, 65, -47, -80, 61 };

    int test(byte[] a) {
        int result = 0;
        for (int i = 1; i < a.length; i += Integer.MAX_VALUE) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1571().test(a));
    }
}
