public class MyJVMTest_8748 {

    static long l = -9223372036854775808L;

    static long stop = 8536651172033845034L;

    boolean shouldStop(long l, long stop) {
        return l >= stop;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8748().shouldStop(l, stop));
    }
}
