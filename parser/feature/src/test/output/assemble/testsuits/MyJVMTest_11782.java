import java.io.PrintStream;

public class MyJVMTest_11782 {

    static String[] argv = { "$f%zkl=8%e", "4s/tk8j$Ml", "NG1RLo`49:", "l\"vyxg#Igr", "3b3pn507tL", "WiNT\\Opa0X", "!6i:IjK3q%", "cX7ud`N\"}g", "{c\\'v`XR'Q", "=n2?:e&dt3" };

    static String outParam1 = "41JycBM.GI";

    static String outParam2 = "4=u#W~Q:K;";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    int OptoRuntime_f2i_Type(PrintStream out) {
        int c1 = 2, c2 = 3, c3 = 4, c4 = 5, c5 = 6;
        int j = 0, k = 0;
        try {
            int[][] iii = (int[][]) (new int[c1][c2]);
            for (j = 0; j < c1; j++) {
                for (k = 0; k < c2; k++) {
                    iii[j][k] = (int) ((float) (j + 1) / (float) (k + 1));
                }
            }
        } catch (Throwable e) {
            out.println("Unexpected exception " + e);
            e.printStackTrace(out);
            out.println("j=" + j + ", k=" + k);
            return 1;
        }
        return 0;
    }

    int run(String[] argv, PrintStream out) {
        int ret = 0, retx = 0, bad = 0;
        for (int i = 0; (i < 100000) && (bad < 10); i++) {
            retx = OptoRuntime_f2i_Type(out);
            ret += retx;
            if (retx != 0) {
                out.println("i=" + i);
                bad++;
            }
        }
        return ret == 0 ? 0 : 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11782().run(argv, out));
    }
}
