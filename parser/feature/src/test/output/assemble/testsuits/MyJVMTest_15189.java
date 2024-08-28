public class MyJVMTest_15189 {

    static long a = 0;

    static long IIMM24_5 = 0x1001000;

    long test_addc5(long a) {
        return a + IIMM24_5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15189().test_addc5(a));
    }
}
