import java.lang.reflect.*;

public class MyJVMTest_13036 {

    static String name = "U=R.?ELSrU";

    Field getAccessibleField(String name) throws NoSuchFieldException {
        Field f = StaticFieldTest.class.getDeclaredField(name);
        f.setAccessible(true);
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13036().getAccessibleField(name));
    }
}
