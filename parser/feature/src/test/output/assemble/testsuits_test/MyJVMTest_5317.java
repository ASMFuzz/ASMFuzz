public class MyJVMTest_5317 {

    static long a = 0;

    long test_ushrc65(long a) {
        return a >>> 65;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5317().test_ushrc65(a));
    }
}
