import java.awt.*;

public class MyJVMTest_13543 {

    static Image img = null;

    static int IMG_WIDTH = 20;

    static int IMG_HEIGHT = 20;

    Graphics drawEmoji(Image img) {
        Graphics g = img.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
        g.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        g.drawString("\uD83D\uDE00", 2, 15);
        g.dispose();
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13543().drawEmoji(img);
    }
}
