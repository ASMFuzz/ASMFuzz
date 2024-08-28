public class MyJVMTest_4500 {

    static byte[] a = { 90, -103, -103, -83, 22, -125, 48, 118, 126, -2 };

    int test(byte[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i += ((0x7fffffff >> 1) + 1)) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4500().test(a));
    }
}
