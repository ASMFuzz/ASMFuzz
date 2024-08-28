import javax.swing.text.*;

public class MyJVMTest_16953 {

    static Document document = new DefaultStyledDocument();

    static String context = "[0PJKYM*Hc";

    static Element parent = null;

    static int position = 720764760;

    int getEndOffset() {
        return position + document.getLength();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16953().getEndOffset());
    }
}
