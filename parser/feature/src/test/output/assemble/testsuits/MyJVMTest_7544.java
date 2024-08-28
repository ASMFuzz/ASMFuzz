import javax.swing.JTable;

public class MyJVMTest_7544 {

    void run() {
        new JTable().getDefaultRenderer(Object.class).getTableCellRendererComponent(null, "a value", true, true, 0, 0);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7544().run();
    }
}
