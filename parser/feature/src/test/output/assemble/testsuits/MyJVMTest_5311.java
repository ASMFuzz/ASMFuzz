public class MyJVMTest_5311 {

    static long a = 6550177926896799322L;

    static long b = 0;

    long test_add(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5311().test_add(a, b));
    }
}
