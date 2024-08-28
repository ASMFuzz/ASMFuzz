import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_7270 {

    static Object value = 5;

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
        new MyJVMTest_7270().waitObservation(value);
    }
}
