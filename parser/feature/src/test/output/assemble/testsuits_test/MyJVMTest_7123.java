public class MyJVMTest_7123 {

    static String[] o = { "NT>BC,fLKs", "sO.g+Gw]By", "dcIY63;i%I", "@Ie>[BM8;v", "qim*7^]YJZ", "YZOPxfoP`m", "L Haqu. LR", "nHRA(6QU`O", "p}HyZM,:N.", "1*$X6box$I" };

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = -1377669125;

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
        System.out.println(new MyJVMTest_7123().arrayToString(o));
    }
}
