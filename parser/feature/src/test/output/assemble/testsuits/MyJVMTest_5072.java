import java.lang.reflect.*;

public class MyJVMTest_5072 {

    static int i = 1;

    static Object o = 7;

    static int ni = -1120540071;

    static Object no = 1;

    static int vi = 0;

    static Object vo = 7;

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
        System.out.println(new MyJVMTest_5072().testAccessiblePrimitive());
    }
}
