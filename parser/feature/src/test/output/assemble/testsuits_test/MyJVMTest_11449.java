import java.io.*;
import java.util.*;
import java.util.logging.*;

public class MyJVMTest_11449 {

    static String name = "QpoVi~v[_y";

    static LogManager INSTANCE = null;

    static Map<String, Logger> namedLoggers = new HashMap<>();

    Logger getLogger(String name) {
        return namedLoggers.get(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11449().getLogger(name));
    }
}
