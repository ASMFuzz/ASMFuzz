public class MyJVMTest_13504 {

    static int a = 0;

    int test_orc2(int a) {
        return a | 0x123456d5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13504().test_orc2(a));
    }
}
