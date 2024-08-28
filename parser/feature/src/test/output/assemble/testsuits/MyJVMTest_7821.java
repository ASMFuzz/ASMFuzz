import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyJVMTest_7821 {

    static int ROW_COUNT = 5;

    static List<Integer> data = new ArrayList<Integer>();

    int getColumnCount() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7821().getColumnCount());
    }
}
