public class MyJVMTest_17675 {

    static int a = 6;

    int test_shrc1(int a) {
        return a >> 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17675().test_shrc1(a));
    }
}
