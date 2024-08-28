public class MyJVMTest_15429 {

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
        new MyJVMTest_15429().foo();
    }
}
