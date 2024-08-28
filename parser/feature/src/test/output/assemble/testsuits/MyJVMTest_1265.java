import java.util.*;
import javax.naming.Context;
import java.io.*;

public class MyJVMTest_1265 {

    static String fqn = "h;:vw}St3]";

    static int exitValue = 0;

    static String output = "0,s{'5-J@P";

    String stackTraceStringForClassNotFound(String fqn) {
        return String.format("Exception in thread \"main\" javax.naming.NoInitialContextException: " + "Cannot instantiate class: %s " + "[Root exception is java.lang.ClassNotFoundException: %s]", fqn, fqn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1265().stackTraceStringForClassNotFound(fqn));
    }
}
