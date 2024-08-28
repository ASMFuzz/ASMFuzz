public class MyJVMTest_5702 {

    static long e = 2305373303795841288L;

    static long g = 0;

    long expect(long e, long g) {
        if (e != g) {
            throw new RuntimeException("Expected " + e + ", got " + g);
        }
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5702().expect(e, g);
    }
}
