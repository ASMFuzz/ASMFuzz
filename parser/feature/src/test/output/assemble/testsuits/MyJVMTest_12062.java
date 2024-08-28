import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;

public class MyJVMTest_12062 {

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

    void testConstructor6() {
        IndexColorModel model1 = new IndexColorModel(8, 3, new int[] { 1, 2, 3 }, 0, true, -1, DataBuffer.TYPE_BYTE);
        IndexColorModel model2 = new IndexColorModel(8, 3, new int[] { 1, 2, 3 }, 0, true, -1, DataBuffer.TYPE_BYTE);
        verifyEquals(model1, model2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12062().testConstructor6();
    }
}
