public class MyJVMTest_8063 {

    static long x = -9223372036854775808L;

    boolean toBoolean(long x) {
        return x > 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8063().toBoolean(x));
    }
}
