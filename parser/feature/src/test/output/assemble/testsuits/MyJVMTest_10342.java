import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class MyJVMTest_10342 {

    static Runnable r = () -> {
    };

    Thread newThread(final Runnable r) {
        return new Thread(r);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10342().newThread(r));
    }
}
