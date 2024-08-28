public class MyJVMTest_11460 {

    static String currentTest = "O\\ld66?0#9";

    static int id = -1;

    void reportJNIError() {
        throw new RuntimeException(currentTest + ": unexpected JNI error");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11460().reportJNIError();
    }
}
