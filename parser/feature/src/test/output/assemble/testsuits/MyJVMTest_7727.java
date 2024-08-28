public class MyJVMTest_7727 {

    static int j = 0;

    int test_helper(int j) {
        return j == 10 ? 10 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7727().test_helper(j));
    }
}
