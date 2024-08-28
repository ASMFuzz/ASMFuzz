import java.awt.AWTException;

public class MyJVMTest_1564 {

    static int width = 50;

    static int height = 50;

    static int x = 0;

    static int y = -1693752495;

    boolean contains(int x, int y) {
        return (x > this.x && x < this.x + width) && (y > this.y && y < this.y + height);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1564().contains(x, y));
    }
}
