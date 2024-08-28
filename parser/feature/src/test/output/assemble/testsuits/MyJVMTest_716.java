import javax.swing.*;
import java.beans.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class MyJVMTest_716 {

    static AtomicInteger lastProgressValue = new AtomicInteger(-1);

    static Exchanger<Boolean> exchanger = new Exchanger<Boolean>();

    void done() {
        boolean isPassed = (lastProgressValue.get() == 100);
        try {
            exchanger.exchange(isPassed);
        } catch (Exception ingore) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_716().done();
    }
}
