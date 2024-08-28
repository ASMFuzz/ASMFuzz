public class MyJVMTest_7618 {

    static long l = -9223372036854775808L;

    static long stop = 0;

    boolean shouldStop(long l, long stop) {
        return l >= stop;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7618().shouldStop(l, stop));
    }
}
