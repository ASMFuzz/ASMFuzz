import java.text.Bidi;

public class MyJVMTest_9406 {

    static String string = "/.rIVwa+__";

    static int rtlstart = -2015228710;

    static int rtllength = 0;

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
        new MyJVMTest_9406().testBidi(string, rtlstart, rtllength);
    }
}
