import java.awt.AWTException;

public class MyJVMTest_10784 {

    static int width = 50;

    static int height = 50;

    static int x = 2;

    static int y = 8;

    boolean contains(int x, int y) {
        return (x > this.x && x < this.x + width) && (y > this.y && y < this.y + height);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10784().contains(x, y));
    }
}
