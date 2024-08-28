import java.lang.invoke.MethodHandle;

public class MyJVMTest_6470 {

    static String name = "\\n.'\\[:vUa";

    static Object rec = 3;

    static MethodHandle getNamedMember = null;

    Object getMember(String name, Object rec) throws Throwable {
        return getNamedMember.invoke(rec, name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6470().getMember(name, rec));
    }
}
