public class MyJVMTest_3324 {

    static int val = 0;

    static Object oField = 6;

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
        new MyJVMTest_3324().test2(val);
    }
}
