import java.awt.Color;

public class MyJVMTest_1726 {

    static String fn = ";& uq3Y7u0";

    static String[] fontNames = { "}$DL$tCdnc", "V3FISI=C8'", "10/)WAQOl\\", "Q7&kM9bh|=", ",$lH!GugM}", "\\s`2M7j,hQ", "&S>^>pI7L8", ",$?;X-<S9P", "Bz&8RkiLl)", "O;Wmsq_/_c" };

    String getFontName(String fn, String[] fontNames) {
        String fontName = null;
        for (String name : fontNames) {
            if (fn.equals(name)) {
                fontName = name;
                break;
            }
        }
        return fontName;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1726().getFontName(fn, fontNames));
    }
}
