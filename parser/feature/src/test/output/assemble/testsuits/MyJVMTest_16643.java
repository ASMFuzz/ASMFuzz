public class MyJVMTest_16643 {

    static String[] o = { "o%/a0FxvDS", "79lbmO/`$A", "&fRiUO*u\\i", "*dJXFWn<Sb", "u%#`|l:+[i", "y%.]&=F.}V", ";0dv(b?ySv", "lL~Q4i1SDy", "8jms>D.iD+", "GoIhq_Ix>q" };

    static int nonStaticPublicField = 907583769;

    static int nonStaticFinalPublicField = -565378461;

    String arrayToString(String[] o) {
        String s = "[";
        if (o == null || o.length == 0) {
            return s + "]";
        }
        for (int i = 0; i < o.length; i++) {
            s += o[i];
            if (i + 1 < o.length) {
                s += ",";
            }
        }
        return s + "]";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16643().arrayToString(o));
    }
}
