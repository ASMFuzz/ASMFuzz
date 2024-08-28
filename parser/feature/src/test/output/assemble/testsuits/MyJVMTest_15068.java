import javax.swing.text.*;

public class MyJVMTest_15068 {

    static Document document = new DefaultStyledDocument();

    static String context = "_i\\='eyoqa";

    static Element parent = null;

    static int position = 789740093;

    int getElementCount() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15068().getElementCount());
    }
}
