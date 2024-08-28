public class MyJVMTest_16608 {

    static byte[] ba = { -76, 42, -47, 77, 125, 96, -115, 1, -27, -45 };

    static long MASK = -9223372036854775808L;

    long doload(byte[] ba) {
        return ba[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16608().doload(ba));
    }
}
