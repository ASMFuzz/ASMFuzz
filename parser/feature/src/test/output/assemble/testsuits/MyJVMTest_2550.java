import java.lang.invoke.*;

public class MyJVMTest_2550 {

    static boolean isTestFailed = false;

    void fail() {
        isTestFailed = true;
        try {
            throw new Exception();
        } catch (Throwable e) {
            StackTraceElement frame = e.getStackTrace()[1];
            System.out.printf("Failed at %s:%d\n", frame.getFileName(), frame.getLineNumber());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2550().fail();
    }
}
