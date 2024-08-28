import javax.swing.text.*;

public class MyJVMTest_7421 {

    static Document document = new DefaultStyledDocument();

    static String context = "55Eya8pFhm";

    static Element parent = null;

    static int position = 7;

    int getEndOffset() {
        return position + document.getLength();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7421().getEndOffset());
    }
}
