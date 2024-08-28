import javax.swing.text.*;

public class MyJVMTest_348 {

    static Document document = new DefaultStyledDocument();

    static String context = "}3oR/{VEon";

    static Element parent = null;

    static int position = 2;

    AttributeSet getAttributes() {
        return new SimpleAttributeSet();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_348().getAttributes());
    }
}
