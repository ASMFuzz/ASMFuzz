import javax.swing.text.*;

public class MyJVMTest_9505 {

    static Document document = new DefaultStyledDocument();

    static String context = "\"z]1~e7ph|";

    static Element parent = null;

    static int position = 5;

    AttributeSet getAttributes() {
        return new SimpleAttributeSet();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9505().getAttributes());
    }
}
