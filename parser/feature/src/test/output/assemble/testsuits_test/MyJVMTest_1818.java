import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MyJVMTest_1818 {

    MethodHandle eqMH() throws NoSuchMethodException, IllegalAccessException {
        return MethodHandles.lookup().findStatic(SimpleOpMethodHandles.class, "eq", MethodType.methodType(boolean.class, Object.class, Object.class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1818().eqMH());
    }
}
