import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_309 {

    static boolean predicate = true;

    static String errMessage = ".S>PFH1mU%";

    static int thing = -2098293477;

    static int thang = 0;

    String abortIfTrue(boolean predicate, String errMessage) {
        if (predicate) {
            throw new RuntimeException(errMessage);
        }
        return errMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_309().abortIfTrue(predicate, errMessage);
    }
}
