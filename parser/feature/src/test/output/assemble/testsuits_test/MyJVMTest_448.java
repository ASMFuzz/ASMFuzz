import java.io.*;

public class MyJVMTest_448 {

    static String output = ";LQ*^g o@w";

    String verify(String output) {
        System.out.println(output);
        if (output.indexOf("InnerClasses") == -1)
            throw new Error("InnerClasses not found in output");
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_448().verify(output);
    }
}
