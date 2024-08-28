import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9260 {

    String getDescription() {
        return "Foo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9260().getDescription());
    }
}
