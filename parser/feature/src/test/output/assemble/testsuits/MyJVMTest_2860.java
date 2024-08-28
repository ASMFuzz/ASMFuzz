import java.lang.reflect.*;

public class MyJVMTest_2860 {

    static Object versionInstance = 0;

    static Method majorMethod = null;

    int major() {
        if (versionInstance != null) {
            try {
                return ((Integer) majorMethod.invoke(versionInstance)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return 8;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2860().major());
    }
}
