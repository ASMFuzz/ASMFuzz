import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_7133 {

    static ColorUIResource secondary1 = new ColorUIResource(0, 0, 0);

    ColorUIResource getSecondary1() {
        return secondary1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7133().getSecondary1());
    }
}
