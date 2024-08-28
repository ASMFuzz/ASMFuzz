import java.math.*;
import java.io.*;

public class MyJVMTest_16946 {

    static long bdParam1 = -9223372036854775808L;

    static int bdParam2Param1 = 395;

    static RoundingMode bdParam2Param2 = null;

    static MathContext bdParam2 = new MathContext(bdParam2Param1, bdParam2Param2);

    static BigDecimal bd = new BigDecimal(bdParam1, bdParam2);

    BigDecimal checkSerialForm(BigDecimal bd) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(bd);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        BigDecimal tmp = (BigDecimal) ois.readObject();
        if (!bd.equals(tmp) || bd.hashCode() != tmp.hashCode()) {
            System.err.print("  original : " + bd);
            System.err.println(" (hash: 0x" + Integer.toHexString(bd.hashCode()) + ")");
            System.err.print("serialized : " + tmp);
            System.err.println(" (hash: 0x" + Integer.toHexString(tmp.hashCode()) + ")");
            throw new RuntimeException("Bad serial roundtrip");
        }
        return bd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16946().checkSerialForm(bd);
    }
}
