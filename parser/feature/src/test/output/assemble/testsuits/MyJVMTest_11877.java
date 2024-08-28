import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_11877 {

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    static Line2D line = new Line2D.Double();

    void randomize() {
        line.setLine(randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11877().randomize();
    }
}
