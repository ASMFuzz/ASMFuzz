import javax.swing.text.*;

public class MyJVMTest_5287 {

    static Document document = new DefaultStyledDocument();

    static String context = "=1l.EOtR^6";

    static Element parent = null;

    static int position = 0;

    String getName() {
        return "StubLeafElement";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5287().getName());
    }
}
