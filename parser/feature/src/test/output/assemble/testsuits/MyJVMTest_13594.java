import java.awt.Font;

public class MyJVMTest_13594 {

    void doTest() {
        Font f = new Font(Font.SANS_SERIF, Font.ITALIC, 24);
        f.getNumGlyphs();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13594().doTest();
    }
}
