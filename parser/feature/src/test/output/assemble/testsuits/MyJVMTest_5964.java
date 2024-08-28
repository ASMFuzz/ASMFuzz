import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_5964 {

    static boolean predicate = false;

    static String errMessage = "O=tLY:eb/3";

    static int errors = 0;

    static int thing = 4;

    static int thang = 3;

    String errorIfTrue(boolean predicate, String errMessage) {
        if (predicate) {
            errors++;
            System.err.println(errMessage);
        }
        return errMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5964().errorIfTrue(predicate, errMessage);
    }
}
