import java.util.*;

public class MyJVMTest_13954 {

    static String tParam1Param1 = "\"HXGm<pSDY";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1);

    static String tParam2 = "Uv4a6#QEo}";

    static Thread t = new Thread(tParam1, tParam2);

    static StackTraceElement[] stack = { null, null, null, null, null, null, null, null, null, null };

    static int depth = 1;

    void printStack(Thread t, StackTraceElement[] stack) {
        System.out.println(t + " stack: (length = " + stack.length + ")");
        if (t != null) {
            for (int j = 0; j < stack.length; j++) {
                System.out.println(stack[j]);
            }
            System.out.println();
        }
    }

    static Object go = new Object();

    static String[] methodNames = { "run", "A", "B", "C", "Done" };

    static boolean trace = false;

    int checkStack(Thread t, StackTraceElement[] stack, int depth) throws Exception {
        if (trace) {
            printStack(t, stack);
        }
        int frame = stack.length - 1;
        for (int i = 0; i < depth && frame >= 0; i++) {
            if (!stack[frame].getMethodName().equals(methodNames[i])) {
                throw new RuntimeException("Expected " + methodNames[i] + " in frame " + frame + " but got " + stack[frame].getMethodName());
            }
            frame--;
        }
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13954().checkStack(t, stack, depth);
    }
}
