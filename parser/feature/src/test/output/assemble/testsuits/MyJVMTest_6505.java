public class MyJVMTest_6505 {

    static long MASK15 = 0x0000_0000_0000_8000L;

    static long andq = 0, orq = 9223372036854775807L;

    void test15() {
        andq &= ~MASK15;
        orq |= MASK15;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6505().test15();
    }
}
