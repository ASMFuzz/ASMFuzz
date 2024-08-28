public class MyJVMTest_11608 {

    static long a = 0;

    static long DIVISOR = 0;

    long divint(long a) {
        return a / DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11608().divint(a));
    }
}
