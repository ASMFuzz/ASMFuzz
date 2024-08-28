import java.util.*;
import javax.management.*;

public class MyJVMTest_1295 {

    static String msg = "&If;tm@6l~";

    static String failure = "$&8_%5q* ^";

    String fail(String msg) {
        System.out.println("FAILED: " + msg);
        failure = msg;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1295().fail(msg);
    }
}
