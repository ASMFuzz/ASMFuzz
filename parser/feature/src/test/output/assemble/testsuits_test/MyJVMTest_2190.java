import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_2190 {

    static ClippedImageCanvas c = null;

    TextArea getInstructions() {
        TextArea ta = new TextArea(18, 60);
        ta.setFont(new Font("Dialog", Font.PLAIN, 11));
        ta.setText("This is a manual test as it requires that you compare " + "the on-screen rendering with the printed output.\n" + "Select the 'Print All' button to print out the test\n" + "It will generate 4 sides of content: as it will print " + "each of 2 sets of transformed images in portrait, \n" + "and landscape orientations. \n" + "The sets of images are in turn made up\n" + "of two similar sets of pages: one is 'random' images,\n " + " the other is 16 squares.\n" + "Use the 'Toggle Contents' button to view the screen rendering\n" + "For each page compare the printed content to the same\n" + "on-screen one taking careful note of\n" + "a) the positions of the red/blue circles on the corners\n" + "b) that numerical text on the image is displayed similarly\n" + "e) that the green quadrilaterals match on-screen\n" + "f) that the rendering is clipped at the default (typically 1 inch) " + "margins of the page.\n" + "The test PASSES if the onscreen and printed rendering match");
        return ta;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2190().getInstructions());
    }
}
