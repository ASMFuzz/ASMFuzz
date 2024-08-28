import java.io.*;

public class MyJVMTest_8881 {

    static String output = "\\OM{a1lSKY";

    String verify(String output) {
        System.out.println(output);
        output = output.substring(output.indexOf("Test.java"));
        if (output.indexOf("-") >= 0)
            throw new Error("- found in output");
        if (output.indexOf("FFFFFF") >= 0)
            throw new Error("FFFFFF found in output");
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8881().verify(output);
    }
}
