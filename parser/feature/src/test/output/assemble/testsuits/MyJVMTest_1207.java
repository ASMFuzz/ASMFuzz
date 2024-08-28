import java.util.concurrent.atomic.AtomicBoolean;

public class MyJVMTest_1207 {

    static AtomicBoolean wasCalled = new AtomicBoolean(false);

    void callback() {
        wasCalled.set(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1207().callback();
    }
}
