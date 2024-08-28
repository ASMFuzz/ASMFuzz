import java.lang.reflect.*;

public class MyJVMTest_5179 {

    static int i = 0;

    static Object o = 4;

    static int ni = 6;

    static Object no = 7;

    static int vi = 7;

    static Object vo = 0;

    static int si = 408 - 343 - 1407;

    boolean testStaticPrimitive() throws NoSuchFieldException {
        try {
            Field f = this.getClass().getDeclaredField("si");
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
        System.out.println(new MyJVMTest_5179().testStaticPrimitive());
    }
}
