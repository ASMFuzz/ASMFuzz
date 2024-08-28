public class MyJVMTest_6887 {

    static int x = 3;

    int test_loop(int x) {
        int sum = 0;
        if (x != 0) {
            for (int y = 1; y < Integer.MAX_VALUE; ++y) {
                if (y % x == 0)
                    ++sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6887().test_loop(x));
    }
}
