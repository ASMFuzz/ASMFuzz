import java.lang.invoke.MethodHandle;

public class MyJVMTest_11997 {

    static MethodHandle mh_SiO = null;

    static MethodHandle mh_vS = null;

    static MethodHandle mh_vi = null;

    static MethodHandle mh_vv = null;

    MethodHandle test(MethodHandle mh_SiO, MethodHandle mh_vS, MethodHandle mh_vi, MethodHandle mh_vv) throws Throwable {
        Object o;
        String s;
        int i;
        mh_SiO.invokeExact("world", 123);
        mh_SiO.invokeExact("mundus", 456);
        Object k = "kosmos";
        mh_SiO.invokeExact((String) k, 789);
        o = mh_SiO.invokeExact((String) null, 000);
        o = (Object) mh_SiO.invokeExact("arda", -123);
        s = (String) mh_vS.invokeExact();
        i = (int) mh_vi.invokeExact();
        o = (int) mh_vi.invokeExact();
        mh_vv.invokeExact();
        return mh_SiO;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11997().test(mh_SiO, mh_vS, mh_vi, mh_vv);
    }
}
