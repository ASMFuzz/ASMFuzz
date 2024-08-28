import java.io.InvalidClassException;

public class MyJVMTest_4214 {

    static Exception e = new Exception();

    Throwable isInvalidClassEx(Exception e) {
        Throwable cause = e;
        while (cause != null) {
            if (cause instanceof InvalidClassException) {
                System.out.println("---NewRMIClientFilterTest-InvalidClassException expected: " + cause);
                return;
            }
            cause = cause.getCause();
        }
        e.printStackTrace();
        throw new RuntimeException("Did not get expected InvalidClassException!");
        return cause;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4214().isInvalidClassEx(e);
    }
}
