import java.text.Bidi;

public class MyJVMTest_255 {

    static String string = "Ia(1}JvY~5";

    static int rtlstart = 5;

    static int rtllength = 4;

    Bidi testBidi(String string, int rtlstart, int rtllength) {
        Bidi bidi = new Bidi(string, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
        for (int i = 0; i < bidi.getRunCount(); ++i) {
            if ((bidi.getRunLevel(i) & 1) != 0) {
                if (bidi.getRunStart(i) != rtlstart || bidi.getRunLimit(i) != rtlstart + rtllength) {
                    throw new RuntimeException("first rtl run didn't match " + rtlstart + ", " + rtllength);
                }
                break;
            }
        }
        return bidi;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_255().testBidi(string, rtlstart, rtllength);
    }
}
