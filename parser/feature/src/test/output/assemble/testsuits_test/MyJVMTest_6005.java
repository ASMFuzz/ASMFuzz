public class MyJVMTest_6005 {

    static long MASK31 = 0x0000_0000_8000_0000L;

    static long andq = 9223372036854775807L, orq = -7989502209995890769L;

    void test31() {
        andq &= ~MASK31;
        orq |= MASK31;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6005().test31();
    }
}
