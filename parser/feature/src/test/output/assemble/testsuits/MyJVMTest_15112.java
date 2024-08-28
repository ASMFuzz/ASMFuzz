import java.io.*;

public class MyJVMTest_15112 {

    static char[] rdrParam1 = { ',', '\\', '0', Character.MIN_VALUE, 'E', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '\\' };

    static Reader rdr = new CharArrayReader(rdrParam1);

    static int[] values = { Integer.MIN_VALUE, -1, 0, 1, 4, 16, 31, 32, 33, Integer.MAX_VALUE };

    static char[][] b = { null, new char[32] };

    int test(Reader rdr) throws Exception {
        int i = 0, j = 0, k = 0;
        boolean nullPtr = false, indexOutBnd = false;
        for (i = 0; i < b.length; i++) {
            for (j = 0; j < values.length; j++) {
                for (k = 0; k < values.length; k++) {
                    nullPtr = (b[i] == null);
                    int bufLen = nullPtr ? 0 : b[i].length;
                    indexOutBnd = ((values[j] + values[k]) < 0) || (values[j] < 0) || (values[j] > bufLen) || (values[k] < 0) || ((values[j] + values[k]) > bufLen);
                    try {
                        rdr.read(b[i], values[j], values[k]);
                    } catch (NullPointerException e) {
                        if (!nullPtr) {
                            throw new Exception("should not throw NullPointerException" + i + " " + j + " " + k);
                        }
                        continue;
                    } catch (IndexOutOfBoundsException e) {
                        if (!indexOutBnd) {
                            throw new Exception("should not throw IndexOutOfBoundsException");
                        }
                        continue;
                    }
                    if (nullPtr || indexOutBnd) {
                        throw new Exception("Should have thrown an exception");
                    }
                }
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15112().test(rdr);
    }
}
