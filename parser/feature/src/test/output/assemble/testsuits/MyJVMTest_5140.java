import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;

public class MyJVMTest_5140 {

    void testColorMapEquality() {
        IndexColorModel model1 = new IndexColorModel(8, 3, new int[] { 1, 2, 3 }, 0, true, -1, DataBuffer.TYPE_BYTE);
        IndexColorModel model2 = new IndexColorModel(8, 3, new int[] { 4, 5, 6 }, 0, true, -1, DataBuffer.TYPE_BYTE);
        if (model1.equals(model2)) {
            throw new RuntimeException("equals() method is determining" + " ColorMap equality improperly");
        }
        if (model2.equals(model1)) {
            throw new RuntimeException("equals() method is determining" + " ColorMap equality improperly");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5140().testColorMapEquality();
    }
}
