import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_807 {

    int getNumberOfPages() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_807().getNumberOfPages());
    }
}
