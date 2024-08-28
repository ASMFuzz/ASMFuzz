public class MyJVMTest_16657 {

    static String[] args = { "I7'qZOn){z", "SgztKJK}Q,", "3D3))2Yi@w", "-ChnwS1G2n", "Ut\\.+&=G;6", "/g@$!?`a?d", "xj/Q?rUc[!", "9\\+WsOpDu`", "83`^FnT?fV", "WF!bBT.y9*" };

    static int v = 9;

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
        System.out.println(new MyJVMTest_16657().initInt(args, v));
    }
}
