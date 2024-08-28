import java.lang.reflect.*;

public class MyJVMTest_17309 {

    static int i = 8;

    static Object o = 0;

    static int ni = 0;

    static Object no = 0;

    static int vi = 0;

    static Object vo = -85738870;

    static int si = 408 - 343 - 1407;

    static Object so = new Object();

    boolean testAccessibleStaticObject() throws NoSuchFieldException {
        Object saved = so;
        try {
            Field f = this.getClass().getDeclaredField("so");
            f.setAccessible(true);
            f.set(this, new Object());
            if (so == saved) {
                System.out.println("set() did not work for static");
            }
            return false;
        } catch (IllegalAccessException iae) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17309().testAccessibleStaticObject());
    }
}
