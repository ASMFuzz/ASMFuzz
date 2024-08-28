public class MyJVMTest_5916 {

    static long a = 9223372036854775807L;

    static long DIVISOR = 0;

    long divcomp(long a) {
        return a / DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5916().divcomp(a));
    }
}
