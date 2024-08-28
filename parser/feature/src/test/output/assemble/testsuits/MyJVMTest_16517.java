public class MyJVMTest_16517 {

    static int val = 3;

    int test3(int val) {
        for (int i = 0; i < 1; ++i) {
            if (val == 0) {
                break;
            }
            val = 0;
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16517().test3(val);
    }
}
