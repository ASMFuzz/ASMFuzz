import java.awt.*;
import javax.swing.*;

public class MyJVMTest_11078 {

    static GraphicsConfiguration toplevelParam1Param1Param1 = null;

    static Frame toplevelParam1Param1 = new Frame(toplevelParam1Param1Param1);

    static Window toplevelParam1 = new Window(toplevelParam1Param1);

    static GraphicsConfiguration toplevelParam2 = null;

    static Window toplevel = new Window(toplevelParam1, toplevelParam2);

    static Component component = new Container();

    static int relativePosition = 0;

    Point setToplevelLocation(Window toplevel, Component component, int relativePosition) {
        Rectangle compBounds = component.getBounds();
        Point p = new Point();
        SwingUtilities.convertPointToScreen(p, component);
        int x;
        int y;
        switch(relativePosition) {
            case SwingConstants.NORTH:
                {
                    x = (p.x + (compBounds.width / 2)) - (toplevel.getWidth() / 2);
                    y = p.y - toplevel.getHeight();
                    break;
                }
            case SwingConstants.EAST:
                {
                    x = p.x + compBounds.width;
                    y = (p.y + (compBounds.height / 2)) - (toplevel.getHeight() / 2);
                    break;
                }
            case SwingConstants.SOUTH:
                {
                    x = (p.x + (compBounds.width / 2)) - (toplevel.getWidth() / 2);
                    y = p.y + compBounds.height;
                    break;
                }
            case SwingConstants.WEST:
                {
                    x = p.x - toplevel.getWidth();
                    y = (p.y + (compBounds.height / 2)) - (toplevel.getHeight() / 2);
                    break;
                }
            case SwingConstants.NORTH_EAST:
                {
                    x = p.x + compBounds.width;
                    y = p.y - toplevel.getHeight();
                    break;
                }
            case SwingConstants.NORTH_WEST:
                {
                    x = p.x - toplevel.getWidth();
                    y = p.y - toplevel.getHeight();
                    break;
                }
            case SwingConstants.SOUTH_EAST:
                {
                    x = p.x + compBounds.width;
                    y = p.y + compBounds.height;
                    break;
                }
            case SwingConstants.SOUTH_WEST:
                {
                    x = p.x - toplevel.getWidth();
                    y = p.y + compBounds.height;
                    break;
                }
            default:
            case SwingConstants.CENTER:
                {
                    x = (p.x + (compBounds.width / 2)) - (toplevel.getWidth() / 2);
                    y = (p.y + (compBounds.height / 2)) - (toplevel.getHeight() / 2);
                }
        }
        toplevel.setLocation(x, y);
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11078().setToplevelLocation(toplevel, component, relativePosition);
    }
}
