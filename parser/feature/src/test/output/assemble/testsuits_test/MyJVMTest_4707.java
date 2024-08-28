import java.util.concurrent.atomic.AtomicBoolean;

public class MyJVMTest_4707 {

    static AtomicBoolean wasCalled = new AtomicBoolean(false);

    boolean wasCalled() {
        return wasCalled.get();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4707().wasCalled());
    }
}
