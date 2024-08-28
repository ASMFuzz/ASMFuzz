import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyJVMTest_4631 {

    static int ROW_COUNT = 5;

    static JTable table = null;

    static List<Integer> data = new ArrayList<Integer>();

    void run() {
        table.getRowSorter().toggleSortOrder(0);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setRowSelectionInterval(1, 2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4631().run();
    }
}
