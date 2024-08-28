import java.util.*;
import java.io.*;

public class MyJVMTest_4110 {

    static Process lastProcess = null;

    Process getLastProcess() {
        try {
            if (null != lastProcess) {
                lastProcess.exitValue();
            }
            return null;
        } catch (IllegalThreadStateException e) {
            return lastProcess;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4110().getLastProcess());
    }
}
