import java.util.*;
import static java.util.GregorianCalendar.*;

public class MyJVMTest_415 {

    static int nThreads = 0;

    void incrementCounter() {
        nThreads++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_415().incrementCounter();
    }
}
