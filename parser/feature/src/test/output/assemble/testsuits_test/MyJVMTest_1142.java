import java.awt.Color;

public class MyJVMTest_1142 {

    static boolean isFirst = true;

    static boolean isWritingCompleted = false;

    static boolean isWritingAborted = false;

    void reset() {
        isWritingAborted = false;
        isWritingCompleted = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1142().reset();
    }
}
