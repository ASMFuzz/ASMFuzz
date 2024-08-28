import java.io.*;
import javax.swing.*;

public class MyJVMTest_17546 {

    ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17546().getRootThreadGroup());
    }
}
