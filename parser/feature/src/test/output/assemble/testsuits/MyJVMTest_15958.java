import java.lang.invoke.MethodHandle;

public class MyJVMTest_15958 {

    static String name = " nLMLQ2aw'";

    static Object rec = 0;

    static MethodHandle getNamedMember = null;

    Object getMember(String name, Object rec) throws Throwable {
        return getNamedMember.invoke(rec, name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15958().getMember(name, rec));
    }
}
