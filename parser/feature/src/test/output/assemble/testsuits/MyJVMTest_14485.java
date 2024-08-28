import java.lang.reflect.*;

public class MyJVMTest_14485 {

    static int i = 3;

    static Object o = 5;

    static int ni = 6;

    static Object no = 0;

    static int vi = 8;

    static Object vo = 0;

    static int si = 408 - 343 - 1407;

    boolean testAccessiblePrimitive() throws NoSuchFieldException {
        try {
            Field f = this.getClass().getDeclaredField("i");
            f.setAccessible(true);
            f.setInt(this, 7);
            if (i != 7) {
                System.out.println("setInt() did not work");
            }
            return true;
        } catch (IllegalAccessException iae) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14485().testAccessiblePrimitive());
    }
}
