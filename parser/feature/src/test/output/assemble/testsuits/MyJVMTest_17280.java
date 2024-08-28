public class MyJVMTest_17280 {

    static int j = -444593532;

    int test_helper(int j) {
        return j == 10 ? 10 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17280().test_helper(j));
    }
}
