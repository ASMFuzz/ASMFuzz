import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8403 {

    int getRowCount() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8403().getRowCount());
    }
}
