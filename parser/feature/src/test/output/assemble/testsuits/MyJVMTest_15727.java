import java.awt.*;

public class MyJVMTest_15727 {

    void testGraphicsDevice(GraphicsDevice device, Frame frame) {
        device.setFullScreenWindow(frame);
        try {
            frame.setOpacity(0.5f);
            throw new RuntimeException("Test fails, there's no exception for device=" + device);
        } catch (IllegalComponentStateException e) {
            device.setFullScreenWindow(null);
        }
    }

    void run() {
        Frame frame = new Frame();
        frame.setBounds(100, 100, 100, 100);
        frame.setVisible(true);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();
        for (GraphicsDevice device : devices) {
            testGraphicsDevice(device, frame);
        }
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15727().run();
    }
}
