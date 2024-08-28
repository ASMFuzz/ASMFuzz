import java.lang.reflect.*;

public class MyJVMTest_16348 {

    static int i = 8;

    static Object o = -1868838216;

    static int ni = 2;

    static Object no = 3;

    static int vi = 5;

    static Object vo = 9;

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
        System.out.println(new MyJVMTest_16348().testStaticObject());
    }
}
