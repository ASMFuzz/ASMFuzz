import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MyJVMTest_3488 {

    MethodHandle notMH() throws NoSuchMethodException, IllegalAccessException {
        return MethodHandles.lookup().findStatic(SimpleOpMethodHandles.class, "not", MethodType.methodType(boolean.class, boolean.class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3488().notMH());
    }
}
