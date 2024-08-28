import static java.awt.Font.*;
import static java.awt.font.GlyphVector.*;
import java.awt.Font;

public class MyJVMTest_9215 {

    static String fParam1Param1 = "#{B%XmEw/[";

    static int fParam1Param2 = 54;

    static int fParam1Param3 = 326;

    static Font fParam1 = new Font(fParam1Param1, fParam1Param2, fParam1Param3);

    static Font f = new Font(fParam1);

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
        System.out.println(new MyJVMTest_9215().isLogicalFont(f));
    }
}
