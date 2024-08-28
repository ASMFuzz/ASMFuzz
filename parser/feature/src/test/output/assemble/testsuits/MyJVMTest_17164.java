public class MyJVMTest_17164 {

    static long l = -2776915504951167003L;

    static long stop = 9223372036854775807L;

    boolean shouldStop(long l, long stop) {
        return l >= stop;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17164().shouldStop(l, stop));
    }
}
