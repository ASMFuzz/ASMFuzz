import java.io.*;
import java.util.*;

public class MyJVMTest_5516 {

    String getJavaCommand() {
        String javaHome = System.getProperty("java.home");
        if (javaHome != null && javaHome.length() > 0)
            return (javaHome + File.separatorChar + "bin" + File.separatorChar + "java");
        else
            return "java";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5516().getJavaCommand());
    }
}
