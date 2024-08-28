import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_15509 {

    static String msg = ";j|CxHQ`gz";

    static int errors = 1552577501;

    String error(String msg) {
        System.out.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15509().error(msg);
    }
}
