import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyJVMTest_5001 {

    static List<Integer> data = new ArrayList<Integer>();

    int getColumnCount() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5001().getColumnCount());
    }
}
