import java.util.*;
import java.io.*;
import java.text.*;

public class MyJVMTest_14453 {

    static long startTime = -1;

    static long stopTime = -1;

    static boolean running = false;

    long getTimeSpent() {
        if (startTime == -1) {
            return 0;
        }
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return stopTime - startTime;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14453().getTimeSpent());
    }
}
