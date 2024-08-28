public class MyJVMTest_13959 {

    static long a = 0;

    static long b = 741821606951418607L;

    long test_div(long a, long b) {
        return a / b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13959().test_div(a, b));
    }
}
