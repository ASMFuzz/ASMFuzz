public class MyJVMTest_15141 {

    static long e = 0;

    static long g = -1526358962893398822L;

    long expect(long e, long g) {
        if (e != g) {
            throw new RuntimeException("Expected " + e + ", got " + g);
        }
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15141().expect(e, g);
    }
}
