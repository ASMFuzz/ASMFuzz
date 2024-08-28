import java.awt.Color;

public class MyJVMTest_10337 {

    static boolean isFirst = true;

    static boolean isWritingCompleted = false;

    static boolean isWritingAborted = false;

    void reset() {
        isWritingAborted = false;
        isWritingCompleted = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10337().reset();
    }
}
