import java.lang.reflect.*;

public class MyJVMTest_3422 {

    static String description = "vx%x@dj-)/";

    static String name = "AZx)JHa [r";

    static boolean pass = true;

    static Method catcher = null;

    String caught(String description, String name) {
        System.out.println("Successfully caught exception in " + description + " frame");
        if (null == catcher) {
            System.out.println("FAIL: Catcher not detected in JVMTI");
            pass = false;
        } else if (name != catcher.getName()) {
            System.out.println("FAIL: Catcher is " + catcher.getName() + " expected " + name);
            pass = false;
        } else {
            System.out.println("JVMTI detected correct catcher");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3422().caught(description, name);
    }
}
