import java.lang.reflect.*;

public class MyJVMTest_215 {

    static int i = 0;

    static Object o = 2;

    static int ni = 0;

    static Object no = 0;

    static int vi = 0;

    static Object vo = 9;

    static int si = 408 - 343 - 1407;

    boolean testAccessibleStaticPrimitive() throws NoSuchFieldException {
        try {
            Field f = this.getClass().getDeclaredField("si");
            f.setAccessible(true);
            f.setInt(this, 13);
            if (si != 13) {
                System.out.println("setInt() did not work for static");
            }
            return false;
        } catch (IllegalAccessException iae) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_215().testAccessibleStaticPrimitive());
    }
}
