public class MyJVMTest_4034 {

    static short[] sa = new short[] { -1 };

    static long MASK = -9223372036854775808L;

    long doload(short[] sa) {
        return sa[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4034().doload(sa));
    }
}
