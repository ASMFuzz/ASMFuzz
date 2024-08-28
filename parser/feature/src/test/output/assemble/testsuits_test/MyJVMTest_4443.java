import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4443 {

    String getName() {
        return "FooName";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4443().getName());
    }
}
