import java.util.concurrent.*;
import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_11052 {

    static int notifs = 8;

    static int called = 2;

    static int nb = 10;

    static int receivedNotifs = 0;

    static int[] lock = new int[0];

    static int calledTimes = 0;

    int check(int notifs, int called) throws Exception {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                if (receivedNotifs < notifs) {
                    lock.wait(1000);
                }
            }
        }
        Thread.sleep(1000);
        synchronized (lock) {
            if (receivedNotifs != notifs) {
                throw new RuntimeException("The listener expected to receive " + notifs + " notifs, but got " + receivedNotifs);
            } else {
                System.out.println(">>> The listener recieved as expected: " + receivedNotifs);
            }
            if (calledTimes != called) {
                throw new RuntimeException("The notif executor should be called " + called + " times, but got " + calledTimes);
            } else {
                System.out.println(">>> The executor was called as expected: " + calledTimes);
            }
        }
        receivedNotifs = 0;
        calledTimes = 0;
        return notifs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11052().check(notifs, called);
    }
}
