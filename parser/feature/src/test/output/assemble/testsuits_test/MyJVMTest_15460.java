public class MyJVMTest_15460 {

    static long MASK31 = 0x0000_0000_8000_0000L;

    static long andq = 9223372036854775807L, orq = -4714171994627315604L;

    void test31() {
        andq &= ~MASK31;
        orq |= MASK31;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15460().test31();
    }
}
