public class MyJVMTest_11250 {

    static long a = 0;

    static long b = 566910324013041762L;

    long test_and(long a, long b) {
        return a & b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11250().test_and(a, b));
    }
}
