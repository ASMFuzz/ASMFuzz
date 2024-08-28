public class MyJVMTest_2207 {

    static String currentTest = "E%#~`uR3|-";

    static int id = -1;

    void reportJNIError() {
        throw new RuntimeException(currentTest + ": unexpected JNI error");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2207().reportJNIError();
    }
}
