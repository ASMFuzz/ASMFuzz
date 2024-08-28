import java.awt.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_13508 {

    static AtomicBoolean isDone = new AtomicBoolean(false);

    void done() {
        isDone.set(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13508().done();
    }
}
