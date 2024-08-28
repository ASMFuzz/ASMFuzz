import java.awt.Font;

public class MyJVMTest_9071 {

    static String fontName = "8ET%_]ew`(";

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
        new MyJVMTest_9071().test(fontName);
    }
}
