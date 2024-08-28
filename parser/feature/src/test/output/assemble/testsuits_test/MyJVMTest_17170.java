public class MyJVMTest_17170 {

    static long MASK63 = 0x8000_0000_0000_0000L;

    static long andq = 0, orq = 548378119893942577L;

    void test63() {
        andq &= ~MASK63;
        orq |= MASK63;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17170().test63();
    }
}
