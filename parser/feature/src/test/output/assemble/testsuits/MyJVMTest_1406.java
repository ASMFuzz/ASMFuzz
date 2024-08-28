import java.io.*;

public class MyJVMTest_1406 {

    static String method = "/\";zT~]!0u";

    static int numGood = 4;

    static int i = 0;

    static String expStr = "=k0Rq}^Egf";

    static int[] off = { -1, -1, 0, 0, 33, 33, 0, 32, 32, 4, 1, 0, -1, Integer.MAX_VALUE, 1 };

    static int[] len = { -1, 0, -1, 33, 0, 4, 32, 0, 4, 16, 31, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };

    static int numBad = 0;

    int printErr(String method, int numGood, int i, String expStr) {
        numBad++;
        System.err.println("\nNumber passed so far = " + numGood + "\nUnexpected " + expStr);
        if (i < 0) {
            System.err.println("for case : b = null");
        } else {
            System.err.println("for case : b.length = " + 32 + " off = " + off[i] + " len = " + len[i]);
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1406().printErr(method, numGood, i, expStr);
    }
}
