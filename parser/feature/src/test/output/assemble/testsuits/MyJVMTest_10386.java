import javax.swing.*;

public class MyJVMTest_10386 {

    static String enabledImage = "g]*W<K)IQ;";

    static String disabledImage = ";vUJ'g*c21";

    JLabel createLabel(String enabledImage, String disabledImage) {
        ImageIcon enabledIcon = enabledImage == null ? null : new ImageIcon(bug4987336.class.getResource(enabledImage));
        ImageIcon disabledIcon = disabledImage == null ? null : new ImageIcon(bug4987336.class.getResource(disabledImage));
        JLabel result = new JLabel(enabledImage == null && disabledImage == null ? "No image" : "Image", enabledIcon, SwingConstants.LEFT);
        result.setDisabledIcon(disabledIcon);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10386().createLabel(enabledImage, disabledImage));
    }
}
