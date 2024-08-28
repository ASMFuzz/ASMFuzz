public class MyJVMTest_16253 {

    static Object[] testArray = new Object[4];

    void run() {
        for (int i = 0; i < 1000000; i++) {
            System.arraycopy(testArray, 1, testArray, 0, 3);
            testArray[2] = new String("a");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16253().run();
    }
}
