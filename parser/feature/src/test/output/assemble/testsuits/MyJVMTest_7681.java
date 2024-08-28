public class MyJVMTest_7681 {

    static int a = 7;

    int test_shrc33(int a) {
        return a >> 33;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7681().test_shrc33(a));
    }
}
