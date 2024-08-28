import java.lang.reflect.*;

public class MyJVMTest_2789 {

    static int i = 4;

    static Object o = -649661974;

    static int ni = 1;

    static Object no = 4;

    static int vi = 2;

    static Object vo = 0;

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
        System.out.println(new MyJVMTest_2789().testPrimitive());
    }
}
