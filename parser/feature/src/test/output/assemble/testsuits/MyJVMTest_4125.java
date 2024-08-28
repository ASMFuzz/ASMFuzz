public class MyJVMTest_4125 {

    static int val = 0;

    static int iField = 0;

    int test1(int val) {
        iField = 0;
        for (int i = 0; i < 1; ++i) {
            if (val == 0) {
                break;
            }
            val = 0;
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4125().test1(val);
    }
}
