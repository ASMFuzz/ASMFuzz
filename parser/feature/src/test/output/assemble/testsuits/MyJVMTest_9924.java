public class MyJVMTest_9924 {

    static String[] args = { "b0F'n=n;Fl", "99tx:6gW$>", "*;<$<hRQ|\\", "o*W;F+6qoN", "0vF[ S4bv-", "Ax-L[q7(oj", "yeprF2)Xm~", "^<OI(=U|qU", "|g-e4a=gE<", "d^.(Y?p90\\" };

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
        System.out.println(new MyJVMTest_9924().initShort(args, v));
    }
}
