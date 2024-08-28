import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_3823 {

    static Counter instance = null;

    static int counter = 5;

    Counter getCounter() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3823().getCounter());
    }
}
