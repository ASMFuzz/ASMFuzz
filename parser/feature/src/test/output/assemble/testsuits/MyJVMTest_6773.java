import java.io.*;
import static java.awt.Color.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.print.*;
import java.awt.image.*;
import static java.awt.image.BufferedImage.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_6773 {

    static ImageCanvas c = null;

    TextArea getInstructions() {
        TextArea ta = new TextArea(10, 60);
        ta.setFont(new Font("Dialog", Font.PLAIN, 11));
        ta.setText("This is a manual test as it requires that you compare " + "the on-screen rendering with the printed output.\n" + "Select the 'Print' button to print out the test.\n" + "For each image compare the printed one to the on-screen one.\n" + "The test PASSES if the onscreen and printed rendering match.");
        return ta;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6773().getInstructions());
    }
}
