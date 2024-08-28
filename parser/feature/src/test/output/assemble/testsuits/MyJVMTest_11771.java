public class MyJVMTest_11771 {

    static int a = 1;

    int test_orc1(int a) {
        return a | 0xf0f0f0f0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11771().test_orc1(a));
    }
}
