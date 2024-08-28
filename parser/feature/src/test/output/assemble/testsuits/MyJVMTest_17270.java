public class MyJVMTest_17270 {

    void test() {
        int i = 34;
        for (; i > 0; i -= 11) ;
        if (i < 0) {
        } else {
            throw new RuntimeException("Test failed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17270().test();
    }
}
