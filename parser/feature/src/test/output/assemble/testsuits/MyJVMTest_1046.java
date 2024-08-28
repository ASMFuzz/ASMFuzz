import java.lang.management.ThreadInfo;

public class MyJVMTest_1046 {

    static StackTraceElement[] aStackElt = { null, null, null, null, null, null, null, null, null, null };

    static Runnable aThreadParam1 = () -> {
    };

    static String aThreadParam2 = "B)mO_zJ{\"T";

    static Thread aThread = new Thread(aThreadParam1, aThreadParam2);

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
        new MyJVMTest_1046().dumpStack(aStackElt, aThread);
    }
}
