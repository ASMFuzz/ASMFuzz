public class MyJVMTest_11243 {

    static String name = ";=Qy44\\KC3";

    static Object rec = 0;

    static java.lang.invoke.MethodHandle getNamedMember = null;

    Object getMember(String name, Object rec) throws Throwable {
        return getNamedMember.invoke(rec, name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11243().getMember(name, rec));
    }
}
