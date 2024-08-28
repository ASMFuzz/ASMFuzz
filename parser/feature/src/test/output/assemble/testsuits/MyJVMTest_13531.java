public class MyJVMTest_13531 {

    static byte[] ba = new byte[] { -1 };

    static long MASK = 9223372036854775807L;

    long doload(byte[] ba) {
        return ba[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13531().doload(ba));
    }
}
