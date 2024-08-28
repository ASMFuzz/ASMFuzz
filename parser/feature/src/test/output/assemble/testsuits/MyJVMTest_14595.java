import java.lang.reflect.*;

public class MyJVMTest_14595 {

    static int i = 2;

    static Object o = -1752682594;

    static int ni = -476029634;

    static Object no = -1529628204;

    static int vi = 1175515221;

    static Object vo = 131610030;

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
        System.out.println(new MyJVMTest_14595().testStaticPrimitive());
    }
}
