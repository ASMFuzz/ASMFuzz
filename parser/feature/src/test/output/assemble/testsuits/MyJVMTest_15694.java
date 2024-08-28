import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_15694 {

    static String msg = "S|@#2<_!>(";

    static int error = 3;

    String noException(String msg) {
        error++;
        System.err.println("no exception with " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15694().noException(msg);
    }
}
