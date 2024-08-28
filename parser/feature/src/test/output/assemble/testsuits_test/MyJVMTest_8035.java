import java.util.*;

public class MyJVMTest_8035 {

    static Runnable tParam1 = () -> {
    };

    static Thread t = new Thread(tParam1);

    static StackTraceElement[] stack = { null, null, null, null, null, null, null, null, null, null };

    StackTraceElement[] printStack(Thread t, StackTraceElement[] stack) {
        System.out.println(t + " stack: (length = " + stack.length + ")");
        if (t != null) {
            for (int j = 0; j < stack.length; j++) {
                System.out.println(stack[j]);
            }
            System.out.println();
        }
        return stack;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8035().printStack(t, stack);
    }
}
