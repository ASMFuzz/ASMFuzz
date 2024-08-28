public class MyJVMTest_2004 {

    static String name = "3/p,'J$47V";

    static Object rec = 3;

    static java.lang.invoke.MethodHandle getNamedMember = null;

    Object getMember(String name, Object rec) throws Throwable {
        return getNamedMember.invoke(rec, name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2004().getMember(name, rec));
    }
}
