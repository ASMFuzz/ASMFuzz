import java.lang.invoke.*;

public class MyJVMTest_3920 {

    static int arg = 2;

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    static MethodHandle C_m = null;

    String m(int arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3920().m(arg));
    }
}
