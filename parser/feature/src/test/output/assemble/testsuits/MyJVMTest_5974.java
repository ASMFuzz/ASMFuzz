public class MyJVMTest_5974 {

    void foo() {
        int len;
        for (; ; ) {
            try {
                len = 1;
                break;
            } catch (Exception e) {
            }
        }
        try {
            if (len == -1) {
                len = 0;
            }
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5974().foo();
    }
}
