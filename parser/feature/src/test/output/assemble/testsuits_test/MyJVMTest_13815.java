public class MyJVMTest_13815 {

    static short[] sa = { 32767, -32768, 0, 32767, 0, 32767, -32768, 0, 32767, 0 };

    static long MASK = -9223372036854775808L;

    long doload(short[] sa) {
        return sa[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13815().doload(sa));
    }
}
