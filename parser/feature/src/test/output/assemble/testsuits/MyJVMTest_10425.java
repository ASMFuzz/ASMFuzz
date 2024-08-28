public class MyJVMTest_10425 {

    static int a = 0;

    static int IIMM24_3 = 0x1000;

    int test_addic3(int a) {
        return a + IIMM24_3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10425().test_addic3(a));
    }
}
