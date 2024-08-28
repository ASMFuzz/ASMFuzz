import java.lang.invoke.MethodHandle;

public class MyJVMTest_9525 {

    static MethodHandle mh_SiO = null;

    static MethodHandle mh_vS = null;

    static MethodHandle mh_vi = null;

    static MethodHandle mh_vv = null;

    Object testGen(MethodHandle mh_SiO, MethodHandle mh_vS, MethodHandle mh_vi, MethodHandle mh_vv) throws Throwable {
        Object o;
        String s;
        int i;
        o = mh_SiO.invoke((Object) "world", (Object) 123);
        mh_SiO.invoke((Object) "mundus", (Object) 456);
        Object k = "kosmos";
        o = mh_SiO.invoke(k, 789);
        o = mh_SiO.invoke(null, 000);
        o = mh_SiO.invoke("arda", -123);
        o = mh_vS.invoke();
        i = (int) mh_vi.invoke();
        o = (int) mh_vi.invoke();
        mh_vi.invoke();
        mh_vv.invoke();
        o = mh_vv.invoke();
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9525().testGen(mh_SiO, mh_vS, mh_vi, mh_vv);
    }
}
