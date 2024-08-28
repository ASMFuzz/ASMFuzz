import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_12734 {

    static ColorUIResource secondary2 = new ColorUIResource(51, 51, 51);

    ColorUIResource getSecondary2() {
        return secondary2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12734().getSecondary2());
    }
}
