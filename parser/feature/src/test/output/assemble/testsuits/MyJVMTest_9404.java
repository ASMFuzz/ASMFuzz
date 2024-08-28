import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9404 {

    void invokeGC() {
        System.out.println("Firing garbage collection!");
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append("any string. some test. a little bit more text." + sb.toString());
            }
        } catch (Throwable e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9404().invokeGC();
    }
}
