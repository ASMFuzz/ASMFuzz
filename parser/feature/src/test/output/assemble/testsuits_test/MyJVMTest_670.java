public class MyJVMTest_670 {

    static int i2 = 0;

    void throwException2() throws Exception {
        if (i2 < 3) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_670().throwException2();
    }
}
