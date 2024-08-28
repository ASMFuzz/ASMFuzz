import java.lang.reflect.*;

public class MyJVMTest_1025 {

    static int i = -1340988277;

    static Object o = 0;

    static int ni = 0;

    static Object no = 5;

    static int vi = 0;

    static Object vo = -1384512410;

    static int si = 408 - 343 - 1407;

    boolean testAccessibleObject() throws NoSuchFieldException {
        Object saved = o;
        try {
            Field f = this.getClass().getDeclaredField("o");
            f.setAccessible(true);
            f.set(this, new Object());
            if (o == saved) {
                System.out.println("set() did not work");
            }
            return true;
        } catch (IllegalAccessException iae) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1025().testAccessibleObject());
    }
}
