import java.io.*;

public class MyJVMTest_9608 {

    static String output = "vO6R$z#(Gl";

    String verify(String output) {
        System.out.println(output);
        if (output.indexOf("InnerClasses") == -1)
            throw new Error("InnerClasses not found in output");
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9608().verify(output);
    }
}
