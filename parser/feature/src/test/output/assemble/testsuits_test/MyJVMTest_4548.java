public class MyJVMTest_4548 {

    static int a = 9;

    static int IIMM24_5 = 0x1001000;

    int test_addic5(int a) {
        return a + IIMM24_5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4548().test_addic5(a));
    }
}
