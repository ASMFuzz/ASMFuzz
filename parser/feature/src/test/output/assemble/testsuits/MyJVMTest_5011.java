public class MyJVMTest_5011 {

    static int a = 1881793542;

    static int IIMM12_0 = 0x1;

    int test_addic0(int a) {
        return a + IIMM12_0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5011().test_addic0(a));
    }
}
