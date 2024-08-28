import static java.awt.Font.*;
import static java.awt.font.GlyphVector.*;
import java.awt.Font;

public class MyJVMTest_72 {

    static Font f = null;

    boolean isLogicalFont(Font f) {
        String family = f.getFamily().toLowerCase();
        switch(family) {
            case "dialog":
            case "dialoginput":
            case "serif":
            case "sansserif":
            case "monospaced":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_72().isLogicalFont(f));
    }
}
