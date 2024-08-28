import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_18134 {

    static boolean doMalformed = false;

    static PrintStream log = System.err;

    static char[] input = {'0',Character.MIN_VALUE,Character.MIN_VALUE,'0','c','=','0','0','0',Character.MIN_VALUE};

    static byte[] output = {119,-1,0,42,7,-76,92,-106,-40,-118};

    boolean testLeftovers(boolean doMalformed) throws Exception {
        log.print("Leftover surrogates, doMalformed = " + doMalformed);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos, Charset.forName("UTF-8"));
        for (int i = 0; i < input.length; i += 7) osw.write(input, i, Math.min(input.length - i, 7));
        if (doMalformed)
            osw.write(input, 0, 1);
        osw.close();
        byte[] result = bos.toByteArray();
        int rl = result.length + (doMalformed ? -1 : 0);
        if (rl != output.length)
            throw new Exception("Incorrect result length " + rl + ", expected " + output.length);
        for (int i = 0; i < output.length; i++) if (result[i] != output[i])
            throw new Exception("Unexpected result value at index " + i);
        log.println(": Passed");
        return doMalformed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18134().testLeftovers(doMalformed);
    }
}
