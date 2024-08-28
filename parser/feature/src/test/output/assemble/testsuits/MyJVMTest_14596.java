import javax.swing.UIManager;

public class MyJVMTest_14596 {

    static String id = "c7R*D_{'88";

    boolean isLookAndFeel(String id) {
        return UIManager.getLookAndFeel().getID().equals(id);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14596().isLookAndFeel(id));
    }
}
