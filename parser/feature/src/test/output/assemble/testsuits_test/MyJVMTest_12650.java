public class MyJVMTest_12650 {

    static int val = -1579550799;

    static Object oField = 4;

    int test2(int val) {
        oField = null;
        for (int i = 0; i < 1; ++i) {
            if (val == 0) {
                break;
            }
            val = 0;
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12650().test2(val);
    }
}
