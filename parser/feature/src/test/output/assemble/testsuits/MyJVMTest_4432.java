public class MyJVMTest_4432 {

    static short[] sa = { 32767, 32767, 0, -30771, -29586, 0, -32768, -32768, 32767, 0 };

    static long MASK = -9223372036854775808L;

    long doload(short[] sa) {
        return sa[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4432().doload(sa));
    }
}
