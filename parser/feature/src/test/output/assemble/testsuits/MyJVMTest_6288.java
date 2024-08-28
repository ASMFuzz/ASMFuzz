import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import static java.lang.annotation.RetentionPolicy.*;

public class MyJVMTest_6288 {

    int testExpressionEval() {
        String s = "a";
        int errors = 2;
        System.out.println("Testing expression evaluation.");
        switch(s + s) {
            case "aa":
                errors = 0;
                break;
            case "aaaa":
                errors = 1;
                System.err.println("Suspected bad expression evaluation.");
                break;
            default:
                throw new RuntimeException("Should not reach here.");
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6288().testExpressionEval());
    }
}
