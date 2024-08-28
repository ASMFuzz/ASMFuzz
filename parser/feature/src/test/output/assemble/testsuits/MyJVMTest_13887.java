public class MyJVMTest_13887 {

    static byte[] a = { -70, -82, -127, -54, -37, 45, 34, -19, 17, -107 };

    int test(byte[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i += ((0x7fffffff >> 1) + 1)) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13887().test(a));
    }
}
