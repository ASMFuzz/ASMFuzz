import java.util.*;
import javax.naming.Context;
import java.io.*;

public class MyJVMTest_17575 {

    static String fqn = "pXbj<i2h}:";

    static int exitValue = 3;

    static String output = "JhJ{FAP,rB";

    boolean verifyOutput(String output, String fqn) {
        String s1 = String.format("Exception in thread \"main\" javax.naming.NoInitialContextException: " + "Cannot load initial context factory '%s' " + "[Root exception is java.util.ServiceConfigurationError: " + "javax.naming.spi.InitialContextFactory: " + "Provider %s could not be instantiated]", fqn, fqn);
        String s2 = String.format("Caused by: java.util.ServiceConfigurationError: " + "javax.naming.spi.InitialContextFactory: " + "Provider %s could not be instantiated", fqn);
        String s3 = "Caused by: java.lang.RuntimeException: " + "This is a broken factory. It is supposed to throw this exception.";
        return output.startsWith(s1) && output.contains(s2) && output.contains(s1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17575().verifyOutput(output, fqn));
    }
}
