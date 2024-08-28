import java.awt.*;

public class MyJVMTest_6691 {

    static int rectParam1 = 853;

    static int rectParam2 = 375;

    static int rectParam3 = 679;

    static int rectParam4 = 638;

    static Rectangle rect = new Rectangle(rectParam1, rectParam2, rectParam3, rectParam4);

    Rectangle getSmallerRectangle(Rectangle rect) {
        return new Rectangle(rect.x + rect.width / 6, rect.y + rect.height / 6, rect.width / 3, rect.height / 3);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6691().getSmallerRectangle(rect));
    }
}
