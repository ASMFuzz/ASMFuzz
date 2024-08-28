import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class MyJVMTest_2464 {

    boolean isRVObserver() {
        Exception e = new Exception();
        for (StackTraceElement elem : e.getStackTrace()) {
            if (elem.getClassName().endsWith("MultiResolutionToolkitImage")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2464().isRVObserver());
    }
}
