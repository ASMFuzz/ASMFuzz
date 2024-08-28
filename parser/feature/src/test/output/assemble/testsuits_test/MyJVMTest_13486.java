public class MyJVMTest_13486 {

    static int val = 5;

    static int iField = 9;

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
        new MyJVMTest_13486().test1(val);
    }
}
