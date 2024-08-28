import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_15807 {

    static ColorUIResource primary1 = new ColorUIResource(51, 142, 71);

    ColorUIResource getPrimary1() {
        return primary1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15807().getPrimary1());
    }
}
