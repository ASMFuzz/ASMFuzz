import java.io.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MyJVMTest_12632 {

    static byte[] serializedData = { 118, -11, -62, 13, 119, 41, 113, 101, -69, 53 };

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
        new MyJVMTest_12632().deserializeGUI(serializedData);
    }
}
