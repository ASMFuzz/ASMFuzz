import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;
import java.math.BigInteger;

public class MyJVMTest_17111 {

    void testValidPixelsEquality() {
        int color = 16777216;
        IndexColorModel model1 = new IndexColorModel(8, 3, new int[] { color, color, color }, 0, DataBuffer.TYPE_BYTE, new BigInteger("1"));
        IndexColorModel model2 = new IndexColorModel(8, 3, new int[] { color, color, color }, 0, DataBuffer.TYPE_BYTE, new BigInteger("2"));
        if (model1.equals(model2)) {
            throw new RuntimeException("equals() method is determining" + " Valid pixels equality improperly");
        }
        if (model2.equals(model1)) {
            throw new RuntimeException("equals() method is determining" + " Valid pixels equality improperly");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17111().testValidPixelsEquality();
    }
}
