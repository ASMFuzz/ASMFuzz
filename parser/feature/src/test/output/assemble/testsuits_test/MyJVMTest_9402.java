import javax.script.*;
import java.util.*;

public class MyJVMTest_9402 {

    static String str = "lh1E\\q_ 5l";

    String getOutputStatement(String str) {
        return "bad-factory-output";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9402().getOutputStatement(str));
    }
}
