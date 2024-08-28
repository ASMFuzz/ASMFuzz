import java.lang.reflect.*;

public class MyJVMTest_16332 {

    static int i = 0;

    static Object o = 2;

    static int ni = 8;

    static Object no = 719796352;

    static int vi = 6;

    static Object vo = 0;

    boolean testObject() throws NoSuchFieldException {
        Object saved = no;
        try {
            Field f = this.getClass().getDeclaredField("no");
            f.set(this, new Object());
            if (no == saved) {
                System.out.println("set() did not work");
            }
            return false;
        } catch (IllegalAccessException iae) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16332().testObject());
    }
}
