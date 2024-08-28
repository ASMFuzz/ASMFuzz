import java.lang.reflect.*;

public class MyJVMTest_6828 {

    static int i = 2;

    static Object o = 3;

    static int ni = 5;

    static Object no = 1;

    static int vi = 3;

    static Object vo = 6;

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
        System.out.println(new MyJVMTest_6828().testObject());
    }
}
