import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_8543 {

    static boolean doMalformed = false;

    static PrintStream log = System.err;

    static char[] input = {Character.MIN_VALUE,'0','0','0','Q',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'(','?'};

    static byte[] output = {-100,18,-25,-111,74,85,111,-73,16,5};

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
        new MyJVMTest_8543().testLeftovers(doMalformed);
    }
}
