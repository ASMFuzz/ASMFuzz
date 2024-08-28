public class MyJVMTest_17925 {

    static long MASK32 = 0x0000_0001_0000_0000L;

    static long andq = 0, orq = 9223372036854775807L;

    void test32() {
        andq &= ~MASK32;
        orq |= MASK32;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17925().test32();
    }
}
