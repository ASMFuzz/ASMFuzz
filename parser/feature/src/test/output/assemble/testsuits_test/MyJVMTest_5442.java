import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5442 {

    String getID() {
        return "FooID";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5442().getID());
    }
}
