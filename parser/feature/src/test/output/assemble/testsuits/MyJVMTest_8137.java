public class MyJVMTest_8137 {

    static long MASK00 = 0x0000_0000_0000_0001L;

    static long andq = -9223372036854775808L, orq = 9223372036854775807L;

    void test00() {
        andq &= ~MASK00;
        orq |= MASK00;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8137().test00();
    }
}
