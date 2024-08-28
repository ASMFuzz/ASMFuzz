public class MyJVMTest_13149 {

    static int a = 7;

    static int IIMM12_1 = 0xfff;

    int test_addic1(int a) {
        return a + IIMM12_1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13149().test_addic1(a));
    }
}
