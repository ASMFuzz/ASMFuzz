import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_9572 {

    static int nThreads = -543643198;

    void incrementCounter() {
        nThreads++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9572().incrementCounter();
    }
}
