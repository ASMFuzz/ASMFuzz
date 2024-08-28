import java.util.*;

public class MyJVMTest_8882 {

    static String out = "$$MB5v w,\"";

    String getConstantPool(String out) {
        int start = out.indexOf("Constant pool:");
        int end = out.indexOf("{");
        return out.substring(start, end);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8882().getConstantPool(out));
    }
}
