import java.lang.reflect.*;

public class MyJVMTest_2062 {

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
        new MyJVMTest_2062().clearNameCache(cl);
    }
}
