import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_16159 {

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    static QuadCurve2D quad = new QuadCurve2D.Double();

    void randomize() {
        quad.setCurve(randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16159().randomize();
    }
}
