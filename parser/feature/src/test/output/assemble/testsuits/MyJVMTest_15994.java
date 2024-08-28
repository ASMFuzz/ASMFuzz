public class MyJVMTest_15994 {

    static long MASK15 = 0x0000_0000_0000_8000L;

    static long andq = -9223372036854775808L, orq = -638899407744201505L;

    void test15() {
        andq &= ~MASK15;
        orq |= MASK15;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15994().test15();
    }
}
