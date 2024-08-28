import java.lang.ref.WeakReference;

public class MyJVMTest_12088 {

    static WeakReference<Object> weakRef = null;

    void createWeakRef() {
        Object o = new Object();
        weakRef = new WeakReference<>(o);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12088().createWeakRef();
    }
}
