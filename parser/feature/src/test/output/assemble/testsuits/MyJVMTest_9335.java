public class MyJVMTest_9335 {

    static int test_helper_i = 9;

    boolean test_helper() {
        test_helper_i++;
        return (test_helper_i & 7) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9335().test_helper());
    }
}
