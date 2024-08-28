import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import sun.awt.*;

public class MyJVMTest_4977 {

    static List<Integer> chunks = new ArrayList<Integer>();

    static JFrame f = null;

    java.util.List<Integer> process(java.util.List<Integer> chunks) {
        for (Integer i : chunks) {
            System.err.println("Processed: " + i);
        }
        return chunks;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4977().process(chunks);
    }
}
