import java.lang.management.*;
import java.util.*;

public class MyJVMTest_14944 {

    void printStack(StackTraceElement[] stack) {
        System.out.println(INDENT + "Stack: (length = " + stack.length + ")");
        for (int j = 0; j < stack.length; j++) {
            System.out.println(INDENT + INDENT + stack[j]);
        }
        System.out.println();
    }

    static String INDENT = "   ";

    void dumpStacks() {
        Map m = Thread.getAllStackTraces();
        Set s = m.entrySet();
        Iterator iter = s.iterator();
        Map.Entry entry;
        while (iter.hasNext()) {
            entry = (Map.Entry) iter.next();
            Thread t = (Thread) entry.getKey();
            StackTraceElement[] stack = (StackTraceElement[]) entry.getValue();
            System.out.println(t);
            printStack(stack);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14944().dumpStacks();
    }
}
