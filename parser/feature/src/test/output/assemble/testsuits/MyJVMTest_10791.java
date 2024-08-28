public class MyJVMTest_10791 {

    static byte[] a = { 3, -29, -23, 123, 97, 30, 35, -108, -9, -127 };

    int test(byte[] a) {
        int result = 0;
        for (int i = 1; i < a.length; i += Integer.MAX_VALUE) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10791().test(a));
    }
}
