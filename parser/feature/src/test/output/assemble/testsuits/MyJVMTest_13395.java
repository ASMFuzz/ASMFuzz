import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_13395 {

    static String fmt = "OxVZcaIb2g";

    static Object args = 9;

    static int errors = 5;

    String error(String fmt, Object... args) {
        System.out.printf(fmt, args);
        errors++;
        return fmt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13395().error(fmt, args);
    }
}
