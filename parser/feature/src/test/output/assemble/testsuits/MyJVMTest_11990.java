import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_11990 {

    static Container parent = new Container();

    static boolean min = false;

    int[][] getGridSizes(Container parent, boolean min) {
        int ncomponents = parent.getComponentCount();
        int nrows = rows;
        int ncols = cols;
        if (nrows > 0) {
            ncols = (ncomponents + nrows - 1) / nrows;
        } else {
            nrows = (ncomponents + ncols - 1) / ncols;
        }
        int[] widths = new int[ncols + 1];
        int[] heights = new int[nrows + 1];
        int x = 0;
        int y = 0;
        for (int i = 0; i < ncomponents; i++) {
            Component comp = parent.getComponent(i);
            Dimension d = (min ? comp.getMinimumSize() : comp.getPreferredSize());
            if (widths[x] < d.width) {
                widths[x] = d.width;
            }
            if (heights[y] < d.height) {
                heights[y] = d.height;
            }
            x++;
            if (x >= ncols) {
                x = 0;
                y++;
            }
        }
        for (int i = 0; i < ncols; i++) {
            widths[ncols] += widths[i];
        }
        for (int i = 0; i < nrows; i++) {
            heights[nrows] += heights[i];
        }
        return new int[][] { widths, heights };
    }

    static int rows = 357304917;

    static int cols = 9;

    static int hgap = 7;

    static int vgap = 8;

    Dimension getSize(Container parent, boolean min) {
        int[][] sizes = getGridSizes(parent, min);
        int[] widths = sizes[0];
        int[] heights = sizes[1];
        int nrows = heights.length - 1;
        int ncols = widths.length - 1;
        int w = widths[ncols];
        int h = heights[nrows];
        Insets insets = parent.getInsets();
        return new Dimension(insets.left + insets.right + w + (ncols + 1) * hgap, insets.top + insets.bottom + h + (nrows + 1) * vgap);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11990().getSize(parent, min));
    }
}
