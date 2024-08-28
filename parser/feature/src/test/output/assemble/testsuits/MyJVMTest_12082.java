import java.lang.reflect.*;

public class MyJVMTest_12082 {

    static int i = 0;

    static Object o = 7;

    static int ni = 0;

    static Object no = 9;

    static int vi = 109584026;

    static Object vo = 3;

    boolean testPrimitive() throws NoSuchFieldException {
        try {
            Field f = this.getClass().getDeclaredField("ni");
            f.setInt(this, 7);
            if (ni != 7) {
                System.out.println("setInt() did not work");
            }
            return false;
        } catch (IllegalAccessException iae) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12082().testPrimitive());
    }
}
