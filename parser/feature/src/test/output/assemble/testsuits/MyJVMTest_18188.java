import java.awt.Font;

public class MyJVMTest_18188 {

    static String fontName = "O,_lI(2\\5B";

    String test(String fontName) {
        System.out.println("name=" + fontName);
        Font font = new Font(fontName, Font.PLAIN, 12);
        System.out.println("font = " + font);
        if (!fontName.equalsIgnoreCase(font.getFamily())) {
            throw new RuntimeException("Requested " + fontName + " but got " + font);
        }
        return fontName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18188().test(fontName);
    }
}
