import javax.script.*;
import java.util.*;

public class MyJVMTest_251 {

    static String str = "^K:9d4lJ9v";

    String getOutputStatement(String str) {
        return "bad-factory-output";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_251().getOutputStatement(str));
    }
}
