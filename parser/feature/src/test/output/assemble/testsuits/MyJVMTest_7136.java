public class MyJVMTest_7136 {

    static String[] args = { "3;#&CMvgGf", "ljf:[/7%6=", "$-[A5BY8dH", "\">l*q4H1dB", "tv@,^l+_|]", "7%nig.cd!P", "k7/CtY||~q", "Ls]MMLe1^m", "^pIs.udW,a", ".7D<z)_yJD" };

    static int v = 0;

    int initInt(String[] args, int v) {
        if (args.length > 0) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7136().initInt(args, v));
    }
}
