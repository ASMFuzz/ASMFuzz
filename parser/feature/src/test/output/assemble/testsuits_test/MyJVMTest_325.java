import java.lang.management.*;
import java.util.*;

public class MyJVMTest_325 {

    static StackTraceElement[] stack = { null, null, null, null, null, null, null, null, null, null };

    static String INDENT = "   ";

    StackTraceElement[] printStack(StackTraceElement[] stack) {
        System.out.println(INDENT + "Stack: (length = " + stack.length + ")");
        for (int j = 0; j < stack.length; j++) {
            System.out.println(INDENT + INDENT + stack[j]);
        }
        System.out.println();
        return stack;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_325().printStack(stack);
    }
}
