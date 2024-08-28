import java.lang.reflect.*;

public class MyJVMTest_11308 {

    static Class cl = null;

    Class clearNameCache(Class cl) {
        try {
            Field f = Class.class.getDeclaredField("name");
            f.setAccessible(true);
            f.set(cl, null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return cl;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11308().clearNameCache(cl);
    }
}
