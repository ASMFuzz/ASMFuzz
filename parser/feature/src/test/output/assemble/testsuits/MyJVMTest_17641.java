import java.lang.invoke.MethodHandle;

public class MyJVMTest_17641 {

    static Object o = 0;

    static MethodHandle mh_getClass = null;

    Class m2(Object o) throws Throwable {
        return (Class) mh_getClass.invokeExact(o);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17641().m2(o));
    }
}
