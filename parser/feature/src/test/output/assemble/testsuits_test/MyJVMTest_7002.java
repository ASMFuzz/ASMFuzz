public class MyJVMTest_7002 {

    static int val = 109623323;

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
        new MyJVMTest_7002().test3(val);
    }
}
