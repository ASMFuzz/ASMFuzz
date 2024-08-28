import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_17074 {

    static Charset cs = null;

    Charset testMixed(Charset cs) throws Throwable {
        CharsetDecoder dec = cs.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        CharsetEncoder enc = cs.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        List<Integer> cps = new ArrayList<>(0x10000);
        int off = 0;
        int cp = 0;
        while (cp < 0x10000) {
            if (enc.canEncode((char) cp)) {
                cps.add(cp);
            }
            cp++;
        }
        Collections.shuffle(cps);
        char[] bmpCA = new char[cps.size()];
        for (int i = 0; i < cps.size(); i++) bmpCA[i] = (char) (int) cps.get(i);
        String bmpStr = new String(bmpCA);
        byte[] bmpBA = bmpStr.getBytes(cs.name());
        ByteBuffer bf = enc.reset().encode(CharBuffer.wrap(bmpCA));
        byte[] baNIO = new byte[bf.limit()];
        bf.get(baNIO, 0, baNIO.length);
        if (!Arrays.equals(bmpBA, baNIO)) {
            throw new RuntimeException("getBytes(csn) failed  -> " + cs.name());
        }
        bmpBA = bmpStr.getBytes(cs);
        if (!Arrays.equals(bmpBA, baNIO)) {
            throw new RuntimeException("getBytes(cs) failed  -> " + cs.name());
        }
        String strSC = new String(bmpBA, cs.name());
        String strNIO = dec.reset().decode(ByteBuffer.wrap(bmpBA)).toString();
        if (!strNIO.equals(strSC)) {
            throw new RuntimeException("new String(csn) failed  -> " + cs.name());
        }
        strSC = new String(bmpBA, cs);
        if (!strNIO.equals(strSC)) {
            throw new RuntimeException("new String(cs) failed  -> " + cs.name());
        }
        return cs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17074().testMixed(cs);
    }
}
