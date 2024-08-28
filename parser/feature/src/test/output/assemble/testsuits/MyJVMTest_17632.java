public class MyJVMTest_17632 {

    static long x = 9223372036854775807L;

    boolean toBoolean(long x) {
        return x > 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17632().toBoolean(x));
    }
}
