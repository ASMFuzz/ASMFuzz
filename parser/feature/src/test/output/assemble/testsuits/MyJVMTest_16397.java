public class MyJVMTest_16397 {

    static int x = 1205006787;

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
        System.out.println(new MyJVMTest_16397().test_loop(x));
    }
}
