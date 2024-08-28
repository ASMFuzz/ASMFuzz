public class MyJVMTest_7624 {

    static long MASK63 = 0x8000_0000_0000_0000L;

    static long andq = 9223372036854775807L, orq = 9223372036854775807L;

    void test63() {
        andq &= ~MASK63;
        orq |= MASK63;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7624().test63();
    }
}
