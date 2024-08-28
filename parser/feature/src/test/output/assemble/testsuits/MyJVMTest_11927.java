import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11927 {

    ThreadGroup getRootThreadGroup() {
        ThreadGroup currentTG = Thread.currentThread().getThreadGroup();
        ThreadGroup parentTG = currentTG.getParent();
        while (parentTG != null) {
            currentTG = parentTG;
            parentTG = currentTG.getParent();
        }
        return currentTG;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11927().getRootThreadGroup());
    }
}
