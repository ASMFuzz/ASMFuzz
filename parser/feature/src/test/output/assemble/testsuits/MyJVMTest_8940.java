import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_8940 {

    static String fmt = "f_}b,/ZX[O";

    static Object args = 0;

    static int errors = 1;

    String error(String fmt, Object... args) {
        System.out.printf(fmt, args);
        errors++;
        return fmt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8940().error(fmt, args);
    }
}
