import java.lang.reflect.*;

public class MyJVMTest_5326 {

    static int i = 6;

    static Object o = 0;

    static int ni = 0;

    static Object no = 0;

    static int vi = 0;

    static Object vo = 4;

    static int si = 408 - 343 - 1407;

    boolean testVolatilePrimitive() throws NoSuchFieldException {
        try {
            Field f = this.getClass().getDeclaredField("vi");
            f.setAccessible(true);
            f.setInt(this, 7);
            if (vi != 7) {
                System.out.println("setInt() did not work");
            }
            return true;
        } catch (IllegalAccessException iae) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5326().testVolatilePrimitive());
    }
}
