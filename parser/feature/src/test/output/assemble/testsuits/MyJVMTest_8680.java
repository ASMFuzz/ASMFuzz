import java.io.*;

public class MyJVMTest_8680 {

    static String output = "Wfko|Aw:s~";

    String verify(String output) {
        System.out.println(output);
        if (output.indexOf("InnerClasses") == -1)
            throw new Error("InnerClasses not found in output");
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8680().verify(output);
    }
}
