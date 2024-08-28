import java.util.*;
import javax.naming.Context;
import java.io.*;

public class MyJVMTest_10466 {

    static String fqn = "*)`TG%.3IP";

    static int exitValue = 753262097;

    static String output = "n\\)BlQ`Y] ";

    String stackTraceStringForClassNotFound(String fqn) {
        return String.format("Exception in thread \"main\" javax.naming.NoInitialContextException: " + "Cannot instantiate class: %s " + "[Root exception is java.lang.ClassNotFoundException: %s]", fqn, fqn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10466().stackTraceStringForClassNotFound(fqn));
    }
}
