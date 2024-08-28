import java.io.*;

public class MyJVMTest_3521 {

    static int outParam1 = 428;

    static OutputStream out = new ByteArrayOutputStream(outParam1);

    OutputStream doTest(OutputStream out) throws Exception {
        int[] off = { -1, -1, 0, 0, 33, 33, 0, 32, 32, 4, 1, 0, -1, Integer.MAX_VALUE, 1, Integer.MIN_VALUE, Integer.MIN_VALUE, 1 };
        int[] len = { -1, 0, -1, 33, 0, 4, 32, 0, 4, 16, 31, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, -1, Integer.MIN_VALUE };
        boolean[] results = { false, false, false, false, false, false, true, true, false, true, true, true, false, false, false, false, false, false };
        int numCases = off.length;
        byte[] b = new byte[32];
        int numBad = 0;
        for (int i = 0; i < numCases; i++) {
            try {
                out.write(b, off[i], len[i]);
            } catch (IndexOutOfBoundsException aiobe) {
                if (results[i]) {
                    System.err.println("Error:IndexOutOfBoundsException thrown" + " for write(b, " + off[i] + " " + len[i] + " ) on " + out + "\nb.length = 32");
                    numBad++;
                } else {
                }
                continue;
            } catch (OutOfMemoryError ome) {
                System.err.println("Error: OutOfMemoryError in write(b, " + off[i] + " " + len[i] + " ) on " + out + "\nb.length = 32");
                numBad++;
                continue;
            }
            if (!results[i]) {
                System.err.println("Error:No IndexOutOfBoundsException thrown" + " for write(b, " + off[i] + " " + len[i] + " ) on " + out + "\nb.length = 32");
                numBad++;
            } else {
            }
        }
        if (numBad > 0) {
            throw new RuntimeException(out + " Failed " + numBad + " cases");
        } else {
            System.err.println("Successfully completed bounds tests on " + out);
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3521().doTest(out);
    }
}
