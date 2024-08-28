import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_3209 {

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    static Rectangle2D rect = new Rectangle2D.Double();

    void randomize() {
        rect.setRect(randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3209().randomize();
    }
}
