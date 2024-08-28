import java.lang.reflect.*;

public class MyJVMTest_14167 {

    static Executable e = null;

    static boolean shouldBeParameterized = false;

    static String msg = "k!8wfp+aUp";

    static int failures = 0;

    static int tests = 0;

    Executable checkAnnotatedReceiverType(Executable e, boolean shouldBeParameterized, String msg) {
        Type t = e.getAnnotatedReceiverType().getType();
        if (shouldBeParameterized != (t instanceof ParameterizedType)) {
            failures++;
            System.err.println(e + ", " + msg + " " + (shouldBeParameterized ? "ParameterizedType" : "Class") + ", found: " + t.getClass().getSimpleName());
        }
        if (shouldBeParameterized) {
            try {
                ParameterizedType t1 = (ParameterizedType) t;
                AnnotatedParameterizedType at1 = (AnnotatedParameterizedType) e.getAnnotatedReceiverType();
                if (t1.getActualTypeArguments().length != at1.getAnnotatedActualTypeArguments().length) {
                    System.err.println(t1 + "'s actual type arguments can't match " + at1);
                    failures++;
                }
            } catch (ClassCastException cce) {
                System.err.println("Couldn't get potentially empty actual type arguments: " + cce.getMessage());
                failures++;
            }
        }
        tests++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14167().checkAnnotatedReceiverType(e, shouldBeParameterized, msg);
    }
}
