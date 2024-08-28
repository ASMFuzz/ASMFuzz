import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_16609 {

    static int outParam1Param1 = 962;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static boolean outParam2 = false;

    static String outParam3 = "P2p4Pc>P #";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16609().OptoRuntime_f2i_Type(out));
    }
}
