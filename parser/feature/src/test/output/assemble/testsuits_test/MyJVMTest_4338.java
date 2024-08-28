import javax.swing.text.*;

public class MyJVMTest_4338 {

    static int offset = 8;

    static Document document = new DefaultStyledDocument();

    static String context = "') mHF{x0~";

    static Element parent = null;

    static int position = 3;

    int getElementIndex(int offset) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4338().getElementIndex(offset));
    }
}
