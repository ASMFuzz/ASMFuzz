import java.lang.management.ThreadInfo;

public class MyJVMTest_10238 {

    static StackTraceElement[] aStackElt = { null, null, null, null, null, null, null, null, null, null };

    static Runnable aThreadParam1 = () -> {
    };

    static Thread aThread = new Thread(aThreadParam1);

    static Thread t1 = null, t2 = null;

    StackTraceElement[] dumpStack(StackTraceElement[] aStackElt, Thread aThread) {
        if (aStackElt != null) {
            System.out.println("Thread:" + aThread.getName() + ": " + aThread.getState());
            for (StackTraceElement element : aStackElt) {
                System.out.println("   " + element);
            }
        }
        return aStackElt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10238().dumpStack(aStackElt, aThread);
    }
}
