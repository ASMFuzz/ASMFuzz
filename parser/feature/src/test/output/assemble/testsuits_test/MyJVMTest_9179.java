public class MyJVMTest_9179 {

    static long a = -9223372036854775808L;

    long test_mulc1(long a) {
        return a * 8;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9179().test_mulc1(a));
    }
}
