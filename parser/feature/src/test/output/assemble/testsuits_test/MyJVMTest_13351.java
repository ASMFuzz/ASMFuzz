import java.lang.invoke.MethodHandle;

public class MyJVMTest_13351 {

    static String MY_STRING = "myString";

    static MethodHandle MH = null;

    String invoke() throws Throwable {
        return (String) MH.invokeExact(this, 0L, (Object) this, MY_STRING);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13351().invoke());
    }
}
