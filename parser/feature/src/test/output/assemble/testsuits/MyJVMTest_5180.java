import javax.swing.UIManager;

public class MyJVMTest_5180 {

    static String id = "a]ETjyMz|L";

    boolean isLookAndFeel(String id) {
        return UIManager.getLookAndFeel().getID().equals(id);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5180().isLookAndFeel(id));
    }
}
