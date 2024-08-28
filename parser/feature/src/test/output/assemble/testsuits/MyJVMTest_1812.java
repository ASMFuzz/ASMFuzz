import javax.swing.*;
import java.io.*;

public class MyJVMTest_1812 {

    void createGui() {
        JTable table = new JTable();
        OutputStream os;
        ObjectOutputStream out;
        try {
            os = new ByteArrayOutputStream();
            out = new ObjectOutputStream(os);
            out.writeObject(table);
            out.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1812().createGui();
    }
}
