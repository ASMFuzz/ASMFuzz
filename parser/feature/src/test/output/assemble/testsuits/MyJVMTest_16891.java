import java.util.concurrent.atomic.AtomicBoolean;

public class MyJVMTest_16891 {

    static AtomicBoolean wasCalled = new AtomicBoolean(false);

    void clear() {
        wasCalled.set(false);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16891().clear();
    }
}
