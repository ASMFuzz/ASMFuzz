import java.util.*;
import java.io.*;

public class MyJVMTest_13471 {

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
        System.out.println(new MyJVMTest_13471().getLastProcess());
    }
}
