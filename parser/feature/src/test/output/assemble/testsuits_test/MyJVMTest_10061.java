import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyJVMTest_10061 {

    static Object source = 7;

    boolean canDecodeInput(Object source) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10061().canDecodeInput(source));
    }
}
