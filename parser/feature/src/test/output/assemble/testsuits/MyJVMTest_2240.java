import java.lang.reflect.*;

public class MyJVMTest_2240 {

    static int i = 1;

    static Object o = 5;

    static int ni = 0;

    static Object no = 5;

    static int vi = 0;

    static Object vo = 7;

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
        System.out.println(new MyJVMTest_2240().testVolatileObject());
    }
}
