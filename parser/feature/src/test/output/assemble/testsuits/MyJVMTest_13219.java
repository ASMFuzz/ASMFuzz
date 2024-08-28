import java.io.*;
import java.util.*;
import java.util.logging.*;

public class MyJVMTest_13219 {

    static LogManager INSTANCE = null;

    static Map<String, Logger> namedLoggers = new HashMap<>();

    Enumeration<String> getLoggerNames() {
        return Collections.enumeration(namedLoggers.keySet());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13219().getLoggerNames());
    }
}
