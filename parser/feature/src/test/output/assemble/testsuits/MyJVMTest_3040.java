import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;
import java.math.BigInteger;

public class MyJVMTest_3040 {

    void verifyEquals(IndexColorModel m1, IndexColorModel m2) {
        if (m1.equals(null)) {
            throw new RuntimeException("equals(null) returns true");
        }
        if (!(m1.equals(m2))) {
            throw new RuntimeException("equals() method is not working" + " properly");
        }
        if (!(m2.equals(m1))) {
            throw new RuntimeException("equals() method is not working" + " properly");
        }
        if (m1.hashCode() != m2.hashCode()) {
            throw new RuntimeException("HashCode is not same for same" + " IndexColorModels");
        }
    }

    void testConstructor7() {
        int color = 16777216;
        IndexColorModel model1 = new IndexColorModel(8, 3, new int[] { color, color, color }, 0, DataBuffer.TYPE_BYTE, new BigInteger("1"));
        IndexColorModel model2 = new IndexColorModel(8, 3, new int[] { color, color, color }, 0, DataBuffer.TYPE_BYTE, new BigInteger("1"));
        verifyEquals(model1, model2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3040().testConstructor7();
    }
}
