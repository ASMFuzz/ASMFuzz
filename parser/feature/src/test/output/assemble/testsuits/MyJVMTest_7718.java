public class MyJVMTest_7718 {

    void test() {
        int i = 34;
        for (; i > 0; i -= 11) ;
        if (i < 0) {
        } else {
            throw new RuntimeException("Test failed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7718().test();
    }
}
