public class MyJVMTest_11042 {

    static int a = -1482329775;

    static int IIMM12_2 = 0x1001;

    int test_addic2(int a) {
        return a + IIMM12_2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11042().test_addic2(a));
    }
}
