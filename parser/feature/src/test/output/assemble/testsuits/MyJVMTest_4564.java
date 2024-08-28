import java.util.*;

public class MyJVMTest_4564 {

    static String tParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1 = "{@UmFE*A>g";

    static ThreadGroup tParam1Param1Param1Param1Param1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1);

    static String tParam1Param1Param1Param1Param1Param1Param1Param1Param2 = "4\"6(j\"YLGr";

    static ThreadGroup tParam1Param1Param1Param1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1Param1Param1Param1, tParam1Param1Param1Param1Param1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param1Param1Param1Param1Param2 = "W*FSHf_|&2";

    static ThreadGroup tParam1Param1Param1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1Param1Param1, tParam1Param1Param1Param1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param1Param1Param1Param2 = "Z[jsCjfV{u";

    static ThreadGroup tParam1Param1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1Param1, tParam1Param1Param1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param1Param1Param2 = "[1^@?[RY=o";

    static ThreadGroup tParam1Param1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1Param1, tParam1Param1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param1Param2 = "GLW\\\"+\\}vB";

    static ThreadGroup tParam1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1, tParam1Param1Param1Param1Param2);

    static String tParam1Param1Param1Param2 = ")H|u+41I's";

    static ThreadGroup tParam1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1, tParam1Param1Param1Param2);

    static String tParam1Param1Param2 = ";1{?ywUR_D";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1, tParam1Param1Param2);

    static String tParam1Param2 = "kC]`L}/rP~";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static Runnable tParam2 = () -> {
    };

    static String tParam3 = "\\ddPC$8i$J";

    static Thread t = new Thread(tParam1, tParam2, tParam3);

    static StackTraceElement[] stack = { null, null, null, null, null, null, null, null, null, null };

    static int depth = -106918881;

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
        new MyJVMTest_4564().checkStack(t, stack, depth);
    }
}
