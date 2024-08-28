import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_9462 {

    static boolean predicate = true;

    static String errMessage = "xwd{C4uoGX";

    static int thing = 0;

    static int thang = 4;

    String abortIfTrue(boolean predicate, String errMessage) {
        if (predicate) {
            throw new RuntimeException(errMessage);
        }
        return errMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9462().abortIfTrue(predicate, errMessage);
    }
}
