import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_16457 {

    static String msg = "iPnE%ot:6]";

    static File file = null;

    static int errors = 3;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16457().error(msg);
    }
}
