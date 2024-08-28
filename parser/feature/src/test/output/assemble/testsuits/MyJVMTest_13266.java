import java.lang.invoke.*;

public class MyJVMTest_13266 {

    static int arg = 0;

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    static MethodHandle C_m = null;

    String m(int arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13266().m(arg));
    }
}
