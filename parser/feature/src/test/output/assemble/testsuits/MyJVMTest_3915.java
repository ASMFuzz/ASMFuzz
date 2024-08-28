import java.util.*;

public class MyJVMTest_3915 {

    static String out = "4b?$b.e-R_";

    String getConstantPool(String out) {
        int start = out.indexOf("Constant pool:");
        int end = out.indexOf("{");
        return out.substring(start, end);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3915().getConstantPool(out));
    }
}
