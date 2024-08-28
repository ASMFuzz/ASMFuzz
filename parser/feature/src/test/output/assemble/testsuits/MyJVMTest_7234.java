public class MyJVMTest_7234 {

    static long a = 9223372036854775807L;

    long test_ushrc1(long a) {
        return a >>> 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7234().test_ushrc1(a));
    }
}
