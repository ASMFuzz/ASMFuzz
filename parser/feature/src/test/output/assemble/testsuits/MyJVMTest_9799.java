import java.io.File;

public class MyJVMTest_9799 {

    static String msg = "FT/.Diu\"a]";

    static T1 obj1 = null;

    static Object obj2 = 554626381;

    String error(String msg) {
        throw new AssertionError(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9799().error(msg);
    }
}
