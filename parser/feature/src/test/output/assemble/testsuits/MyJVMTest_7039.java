import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_7039 {

    static int nThreads = 9;

    void decrementCounter() {
        nThreads--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7039().decrementCounter();
    }
}
