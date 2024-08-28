import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13647 {

    Container getParent() {
        return new Frame();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13647().getParent());
    }
}
