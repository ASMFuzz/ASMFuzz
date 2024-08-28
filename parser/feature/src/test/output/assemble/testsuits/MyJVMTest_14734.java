public class MyJVMTest_14734 {

    static long a = -9195111187452323399L;

    static long b = 0;

    long test_add(long a, long b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14734().test_add(a, b));
    }
}
