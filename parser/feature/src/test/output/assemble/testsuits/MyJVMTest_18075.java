import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_18075 {

    static Semaphore semaphore = new Semaphore(0);

    static Object wrapped = 5;

    void await() throws InterruptedException {
        semaphore.acquire();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18075().await();
    }
}
