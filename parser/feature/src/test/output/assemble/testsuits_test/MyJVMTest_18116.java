import javax.swing.*;
import java.awt.*;

public class MyJVMTest_18116 {

    int getColumnCount() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18116().getColumnCount());
    }
}
