import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_9137 {

    static String msg = "w6[3#${bH4";

    static int errors = 5;

    String error(String msg) {
        System.out.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9137().error(msg);
    }
}
