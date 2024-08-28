import javax.swing.*;

public class MyJVMTest_1187 {

    static String enabledImage = "1@`hiY}uYP";

    static String disabledImage = "k:_(M>hlW4";

    JLabel createLabel(String enabledImage, String disabledImage) {
        ImageIcon enabledIcon = enabledImage == null ? null : new ImageIcon(bug4987336.class.getResource(enabledImage));
        ImageIcon disabledIcon = disabledImage == null ? null : new ImageIcon(bug4987336.class.getResource(disabledImage));
        JLabel result = new JLabel(enabledImage == null && disabledImage == null ? "No image" : "Image", enabledIcon, SwingConstants.LEFT);
        result.setDisabledIcon(disabledIcon);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1187().createLabel(enabledImage, disabledImage));
    }
}
