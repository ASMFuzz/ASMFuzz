public class MyJVMTest_9841 {

    static int i2 = 8;

    void throwException2() throws Exception {
        if (i2 < 3) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9841().throwException2();
    }
}
