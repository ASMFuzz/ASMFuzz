import java.awt.Font;

public class MyJVMTest_8596 {

    static String fontName = ".uv9l<q@AD";

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
        new MyJVMTest_8596().test(fontName);
    }
}
