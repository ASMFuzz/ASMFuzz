import javax.swing.text.*;

public class MyJVMTest_14710 {

    static Document document = new DefaultStyledDocument();

    static String context = "i*`+?HWYb?";

    static Element parent = null;

    static int position = 1;

    String getName() {
        return "StubLeafElement";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14710().getName());
    }
}
