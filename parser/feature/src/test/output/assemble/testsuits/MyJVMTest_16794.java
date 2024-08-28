import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_16794 {

    static Object value = 4;

    static Object observedValue = null;

    Object waitObservation(Object value) {
        synchronized (CounterMonitorTest.class) {
            while (value != observedValue) {
                try {
                    CounterMonitorTest.class.wait();
                } catch (InterruptedException e) {
                    System.err.println("Got unexpected exception: " + e);
                    e.printStackTrace();
                    break;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16794().waitObservation(value);
    }
}
