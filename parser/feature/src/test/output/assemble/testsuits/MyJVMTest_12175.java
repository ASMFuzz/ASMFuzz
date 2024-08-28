import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_12175 {

    double randDblCoord() {
        return Math.random() * 60 - 10;
    }

    static CubicCurve2D cubic = new CubicCurve2D.Double();

    void randomize() {
        cubic.setCurve(randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord(), randDblCoord());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12175().randomize();
    }
}
