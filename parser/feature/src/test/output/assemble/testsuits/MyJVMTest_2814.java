import java.lang.ref.WeakReference;

public class MyJVMTest_2814 {

    static int i = 0;

    static WeakReference<Object> ref = null;

    static int val = 0;

    Object foo(int i) {
        Object o = new Object();
        ref = new WeakReference<Object>(o);
        if (val == 200) {
            if (o instanceof UncommonTrapLeak) {
            }
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2814().foo(i);
    }
}
