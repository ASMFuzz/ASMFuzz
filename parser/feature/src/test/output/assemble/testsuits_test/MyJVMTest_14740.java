public class MyJVMTest_14740 {

    static long a = 9223372036854775807L;

    long test_ushrc65(long a) {
        return a >>> 65;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14740().test_ushrc65(a));
    }
}
