import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_10472 {

    static Semaphore semaphore = new Semaphore(0);

    static Object wrapped = 0;

    void checkUnavailable() throws Exception {
        if (semaphore.tryAcquire())
            throw new Exception("Got extra notifications!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10472().checkUnavailable();
    }
}
