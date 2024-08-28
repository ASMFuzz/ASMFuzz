public class MyJVMTest_9514 {

    static int a = 7;

    int test_neg(int a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9514().test_neg(a));
    }
}
