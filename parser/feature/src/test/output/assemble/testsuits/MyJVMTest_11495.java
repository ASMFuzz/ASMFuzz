import java.lang.reflect.*;

public class MyJVMTest_11495 {

    static int i = 6;

    static Object o = 8;

    static int ni = 0;

    static Object no = 0;

    static int vi = 4;

    static Object vo = 0;

    static int si = 408 - 343 - 1407;

    boolean testVolatileObject() throws NoSuchFieldException {
        Object saved = vo;
        try {
            Field f = this.getClass().getDeclaredField("vo");
            f.setAccessible(true);
            f.set(this, new Object());
            if (vo == saved) {
                System.out.println("set() did not work");
            }
            return true;
        } catch (IllegalAccessException iae) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11495().testVolatileObject());
    }
}
