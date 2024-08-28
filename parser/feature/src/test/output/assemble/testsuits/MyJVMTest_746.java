public class MyJVMTest_746 {

    static String[] args = { "N<rRZYEFxG", "_5F O,}a{x", "^av8GV39lh", "+P&z@^`K&~", "eC@DnTFV| ", "'m!F*d8WJQ", "46[qm`ua<9", "EfE72pqU97", "U7N`+R-H?%", "`?QT-=\\Rh5" };

    static short v = 32767;

    short initShort(String[] args, short v) {
        if (args.length > 0) {
            try {
                return (short) Integer.valueOf(args[0]).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_746().initShort(args, v));
    }
}
