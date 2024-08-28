public class MyJVMTest_4143 {

    static int a = 4;

    int test_orc2(int a) {
        return a | 0x123456d5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4143().test_orc2(a));
    }
}
