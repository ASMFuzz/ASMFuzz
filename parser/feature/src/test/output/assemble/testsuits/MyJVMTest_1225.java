public class MyJVMTest_1225 {

    static int a = -1717440952;

    static int IIMM24_3 = 0x1000;

    int test_addic3(int a) {
        return a + IIMM24_3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1225().test_addic3(a));
    }
}
