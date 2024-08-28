import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_4041 {

    static String fmt = "Jxa4at7i5D";

    static Object args = 6;

    static int errors = 4;

    String error(String fmt, Object... args) {
        System.out.printf(fmt, args);
        errors++;
        return fmt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4041().error(fmt, args);
    }
}
