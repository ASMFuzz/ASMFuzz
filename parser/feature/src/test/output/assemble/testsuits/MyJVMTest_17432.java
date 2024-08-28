import java.text.Bidi;

public class MyJVMTest_17432 {

    static String string = "YnP5}L`c2s";

    static boolean directionIsRTL = false;

    boolean testBidi(String string, boolean directionIsRTL) {
        Bidi bidi = new Bidi(string, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
        if (bidi.isMixed()) {
            throw new RuntimeException("bidi is mixed");
        }
        if (bidi.isRightToLeft() != directionIsRTL) {
            throw new RuntimeException("bidi is not " + (directionIsRTL ? "rtl" : "ltr"));
        }
        return directionIsRTL;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17432().testBidi(string, directionIsRTL);
    }
}
