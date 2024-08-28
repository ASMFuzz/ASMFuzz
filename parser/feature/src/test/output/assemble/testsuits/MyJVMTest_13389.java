import java.awt.*;

public class MyJVMTest_13389 {

    static Graphics2D g2 = null;

    Graphics2D render(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, 100, 100);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 0.5f));
        g2.setColor(Color.RED);
        g2.fillRect(10, 10, 80, 80);
        return g2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13389().render(g2);
    }
}
