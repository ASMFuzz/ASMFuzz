import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_16555 {

    static int nThreads = 476793804;

    void decrementCounter() {
        nThreads--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16555().decrementCounter();
    }
}
