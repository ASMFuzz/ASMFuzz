import java.lang.reflect.*;

public class MyJVMTest_6284 {

    String helpExceptions() {
        return "Decompile at exception catch at various levels of inlining";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6284().helpExceptions());
    }
}
