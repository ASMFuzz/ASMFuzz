import java.awt.*;

public class MyJVMTest_9584 {

    static GraphicsDevice device = null;

    static String frameParam1 = ";dKc1^co N";

    static Frame frame = new Frame(frameParam1);

    GraphicsDevice testGraphicsDevice(GraphicsDevice device, Frame frame) {
        device.setFullScreenWindow(frame);
        try {
            frame.setOpacity(0.5f);
            throw new RuntimeException("Test fails, there's no exception for device=" + device);
        } catch (IllegalComponentStateException e) {
            device.setFullScreenWindow(null);
        }
        return device;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9584().testGraphicsDevice(device, frame);
    }
}
