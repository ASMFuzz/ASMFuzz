import javax.swing.*;
import java.awt.*;

public class MyJVMTest_3556 {

    static Component left = null;

    void test() throws Exception {
        if (left.getSize().width == 100) {
            System.out.println("Test passed");
        } else {
            throw new RuntimeException("ScrollPaneLayout sometimes improperly " + "calculates the preferred layout size. ");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3556().test();
    }
}
