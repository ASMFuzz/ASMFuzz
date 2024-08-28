public class MyJVMTest_6550 {

    static long a = -9223372036854775808L;

    long test_shrc65(long a) {
        return a >> 65;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6550().test_shrc65(a));
    }
}
