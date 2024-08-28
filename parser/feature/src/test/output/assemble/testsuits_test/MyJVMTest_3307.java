import java.io.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MyJVMTest_3307 {

    static byte[] serializedData = { -52, 29, 13, -16, -48, -74, 57, 78, -55, 3 };

    byte[] deserializeGUI(byte[] serializedData) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedData));
            JPanel mainPanel = (JPanel) ois.readObject();
            JFrame frame = new JFrame("Deserialization");
            frame.getContentPane().add(mainPanel);
            frame.pack();
            frame.dispose();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return serializedData;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3307().deserializeGUI(serializedData);
    }
}
