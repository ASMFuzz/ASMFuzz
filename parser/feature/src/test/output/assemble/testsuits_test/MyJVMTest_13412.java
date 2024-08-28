import java.util.*;
import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_13412 {

    static Semaphore semaphore = new Semaphore(0);

    void await() throws InterruptedException {
        semaphore.acquire();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13412().await();
    }
}
