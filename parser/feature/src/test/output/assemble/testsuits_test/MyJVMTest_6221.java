import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_6221 {

    static String msg = "t/W3c97nft";

    static int error = 1866452182;

    String noException(String msg) {
        error++;
        System.err.println("no exception with " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6221().noException(msg);
    }
}
