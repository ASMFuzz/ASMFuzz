import java.util.*;

public class MyJVMTest_13259 {

    static String out = "-83Mkf7^h/";

    String getConstantPool(String out) {
        int start = out.indexOf("Constant pool:");
        int end = out.indexOf("{");
        return out.substring(start, end);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13259().getConstantPool(out));
    }
}
