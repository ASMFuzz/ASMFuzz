import java.lang.reflect.*;

public class MyJVMTest_6843 {

    static int i = 2;

    static Object o = 855951050;

    static int ni = 9;

    static Object no = 3;

    static int vi = 9;

    static Object vo = 1;

    static Object so = new Object();

    boolean testStaticObject() throws NoSuchFieldException {
        Object saved = so;
        try {
            Field f = this.getClass().getDeclaredField("so");
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
        System.out.println(new MyJVMTest_6843().testStaticObject());
    }
}
