import java.awt.Color;

public class MyJVMTest_10949 {

    static String fn = "C]RWaZc)*i";

    static String[] fontNames = { "+Ei ]i=/<A", "]$m{eosYFa", "}fI}XlOM*|", "<eFEBR&UzM", "mc4LV^T4f+", "[ugk<%1#\"D", "YXc$>ZeXw%", "+y_Z8uA+zm", "fyWi/||k$e", "QU,nzTk@}[" };

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
        System.out.println(new MyJVMTest_10949().getFontName(fn, fontNames));
    }
}
