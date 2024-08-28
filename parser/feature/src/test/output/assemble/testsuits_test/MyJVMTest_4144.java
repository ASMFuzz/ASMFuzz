import java.awt.color.ColorSpace;
import java.awt.image.DataBuffer;
import java.awt.image.DirectColorModel;

public class MyJVMTest_4144 {

    void verifyEquals(DirectColorModel m1, DirectColorModel m2) {
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
            throw new RuntimeException("HashCode is not same for same" + " PackedColorModels");
        }
    }

    void testConstructor2() {
        DirectColorModel model1 = new DirectColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), 32, 0xFF000000, 0x00FF0000, 0x0000FF00, 0x000000FF, false, DataBuffer.TYPE_BYTE);
        DirectColorModel model2 = new DirectColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), 32, 0xFF000000, 0x00FF0000, 0x0000FF00, 0x000000FF, false, DataBuffer.TYPE_BYTE);
        verifyEquals(model1, model2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4144().testConstructor2();
    }
}
