public class MyJVMTest_18061 {

    static long a = -9223372036854775808L;

    long test_neg(long a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18061().test_neg(a));
    }
}
