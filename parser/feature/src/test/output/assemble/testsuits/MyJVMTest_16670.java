import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_16670 {

    static ColorUIResource primary1 = new ColorUIResource(80, 10, 22);

    ColorUIResource getPrimary1() {
        return primary1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16670().getPrimary1());
    }
}
