import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_17897 {

    Dimension getPreferredSize() {
        return new Dimension(10, 10);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17897().getPreferredSize());
    }
}
