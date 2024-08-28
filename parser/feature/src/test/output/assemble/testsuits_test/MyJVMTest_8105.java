public class MyJVMTest_8105 {

    static int a = 1;

    int test_shrc1(int a) {
        return a >> 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8105().test_shrc1(a));
    }
}
