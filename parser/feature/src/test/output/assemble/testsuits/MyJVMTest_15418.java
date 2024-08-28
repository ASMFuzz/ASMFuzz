import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_15418 {

    static boolean predicate = false;

    static String errMessage = "N>X@KS{C|-";

    static int errors = 0;

    static int thing = 0;

    static int thang = 0;

    String errorIfTrue(boolean predicate, String errMessage) {
        if (predicate) {
            errors++;
            System.err.println(errMessage);
        }
        return errMessage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15418().errorIfTrue(predicate, errMessage);
    }
}
