public class MyJVMTest_13936 {

    static int a = -1610548131;

    static int IIMM24_5 = 0x1001000;

    int test_addic5(int a) {
        return a + IIMM24_5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13936().test_addic5(a));
    }
}
