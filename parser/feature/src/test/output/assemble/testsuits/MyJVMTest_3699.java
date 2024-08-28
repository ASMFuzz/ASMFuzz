import java.lang.reflect.*;

public class MyJVMTest_3699 {

    static String name = "oP:[uwfPU0";

    Field getAccessibleField(String name) throws NoSuchFieldException {
        Field f = StaticFieldTest.class.getDeclaredField(name);
        f.setAccessible(true);
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3699().getAccessibleField(name));
    }
}
