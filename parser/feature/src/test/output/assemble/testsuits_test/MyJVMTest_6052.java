import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_6052 {

    static String msg = "n#Pvw:* 0T";

    static int errors = 1516552174;

    String error(String msg) {
        System.out.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6052().error(msg);
    }
}
