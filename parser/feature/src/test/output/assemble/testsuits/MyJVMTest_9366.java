import java.lang.reflect.*;

public class MyJVMTest_9366 {

    static int i = 0;

    static Object o = 0;

    static int ni = 1454078989;

    static Object no = 1277512394;

    static int vi = 5;

    static Object vo = -1594700129;

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
        System.out.println(new MyJVMTest_9366().testAccessibleStaticPrimitive());
    }
}
