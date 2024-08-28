import java.io.*;
import java.awt.*;
import java.awt.font.*;
import java.util.*;

public class MyJVMTest_16339 {

    static Graphics g = new Graphics2D();

    static Font font1 = null;

    static Font font2 = null;

    Graphics2D paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout("text", font2, frc);
        layout.draw(g2, 10, 150);
        String s = "WAVATastic";
        TextLayout layout2 = new TextLayout(s, font1, frc);
        layout2.draw(g2, 10, 200);
        TextLayout layout3 = new TextLayout(s, font2, frc);
        layout3.draw(g2, 10, 100);
        return g2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16339().paint(g);
    }
}
