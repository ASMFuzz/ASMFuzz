import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.event.*;
import javax.imageio.stream.*;

public class MyJVMTest_11468 {

    static boolean progressive = true;

    ImageInputStream createTestImageStream(boolean progressive) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("gif");
        if (!writers.hasNext()) {
            return null;
        }
        ImageWriter writer = writers.next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setProgressiveMode(progressive ? ImageWriteParam.MODE_DEFAULT : ImageWriteParam.MODE_DISABLED);
        ImageOutputStream imageOutput = ImageIO.createImageOutputStream(output);
        writer.setOutput(imageOutput);
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        writer.write(null, new IIOImage(image, null, null), param);
        imageOutput.flush();
        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
        return ImageIO.createImageInputStream(input);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11468().createTestImageStream(progressive));
    }
}
