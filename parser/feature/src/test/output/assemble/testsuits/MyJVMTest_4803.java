public class MyJVMTest_4803 {

    static int a = 2;

    static int IIMM24_4 = 0xfff000;

    int test_addic4(int a) {
        return a + IIMM24_4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4803().test_addic4(a));
    }
}
