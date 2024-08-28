public class MyJVMTest_17233 {

    static int a = 5;

    int test_shrc33(int a) {
        return a >> 33;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17233().test_shrc33(a));
    }
}
