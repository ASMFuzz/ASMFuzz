public class MyJVMTest_2346 {

    static long a = -452456760028590961L;

    static long DIVISOR = -9223372036854775808L;

    long divint(long a) {
        return a / DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2346().divint(a));
    }
}
