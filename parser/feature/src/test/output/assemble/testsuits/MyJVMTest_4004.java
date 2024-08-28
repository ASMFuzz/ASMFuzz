import java.io.*;

public class MyJVMTest_4004 {

    static String testPath = "f+,/Xy)*v]";

    void invokeJava() throws Exception {
        String command = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java -classpath " + "a#b/ Hello";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
        int result = p.exitValue();
        if (result != 0)
            throw new RuntimeException("Path encoding failure.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4004().invokeJava();
    }
}
