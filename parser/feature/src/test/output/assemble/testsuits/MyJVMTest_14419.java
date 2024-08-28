public class MyJVMTest_14419 {

    static int a = 4;

    static int IIMM12_0 = 0x1;

    int test_addic0(int a) {
        return a + IIMM12_0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14419().test_addic0(a));
    }
}
