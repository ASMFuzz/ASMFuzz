import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_14388 {

    static Calendar.Builder calb = new Calendar.Builder();

    static Class<? extends Exception> exception = null;

    static int error = 3;

    Class<? extends Exception> checkException(Calendar.Builder calb, Class<? extends Exception> exception) {
        try {
            Calendar cal = calb.build();
            error++;
            System.err.println("expected exception: " + exception);
        } catch (Exception e) {
            if (!e.getClass().equals(exception)) {
                error++;
                System.err.println("unexpected exception: " + e.getClass() + ", expected: " + exception);
            }
        }
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14388().checkException(calb, exception);
    }
}
